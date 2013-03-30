package gt.cs4420.relationaldb.database.storage.block;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

/**
 * TODO:
 * * Figure out the best way to handle what determines the "size" of a block (currently an attribute count)
 * * Keep data in sorted order by primary key
 */
public class BlockManager {

    //The maximum amount of attributes to store in a single block
    private final int MAX_BLOCK_SIZE = 16;

    //Table ID -> (Block ID -> Block)
    private Map<Integer, Map<Integer, Block>> tableBlocks;
    //Table ID -> Block ID
    private Map<Integer, Integer> nextBlockIds;
 
    public BlockManager() {
        tableBlocks = Maps.newHashMap();
        nextBlockIds = Maps.newHashMap();
    }
    
    public Set<Integer> getBlockIdSet(final Integer tableId) {
        return tableBlocks.get(tableId).keySet();
    }

    public Block getBlock(final Integer tableId, final Integer blockId) {
        Map<Integer, Block> blocks = tableBlocks.get(tableId);

        if (blocks == null) {
            return null;
        }

        return blocks.get(blockId);
    }

    /**
     * Allocates space in an available block of the given table ID and returns the ID of the assigned block.
     *
     * @param tableId Integer ID for the table in which space is needed
     * @param requestedSize the amount of space needed
     * @return Integer the block ID in which space was allocated
     */
    public Integer allocateBlockSpace(final Integer tableId, final int requestedSize) {
        Map<Integer, Block> blocks = tableBlocks.get(tableId);

        if (blocks == null) {
            blocks = Maps.newHashMap();
            tableBlocks.put(tableId, blocks);
        }

        //If the requested size is small enough, it will share a block with other data
        if (requestedSize < MAX_BLOCK_SIZE) {

            //Find the first block with enough space to be allocated
            for (Integer blockId : blocks.keySet()) {
                Integer currBlockSize = blocks.get(blockId).getBlockSize();

                if (currBlockSize + requestedSize <= MAX_BLOCK_SIZE) {
                    blocks.get(blockId).setBlockSize(currBlockSize + requestedSize);
                    return blockId;
                }
            }
        }

        //No available blocks, allocate a new one
        Integer newBlockId = addBlock(tableId);
        blocks.put(newBlockId, new Block(newBlockId, requestedSize));

        return newBlockId;
    }

    public Integer getBlockSize(final Integer tableId, final Integer blockId) {
        Integer blockSize = tableBlocks.get(tableId).get(blockId).getBlockSize();

        if (blockSize == null) {
            throw new IllegalArgumentException("No block with ID: " + blockId + " has been allocated for table with ID: " + tableId);
        }

        return blockSize;
    }

    public void setBlockSize(final Integer tableId, final Integer blockId, final Integer blockSize) {
        Map<Integer, Block> blocks = tableBlocks.get(tableId);

        if (blocks == null) {
            blocks = Maps.newHashMap();
            tableBlocks.put(tableId, blocks);
        }

        if (blocks.get(blockId) != null) {
            blocks.get(blockId).setBlockSize(blockSize);
        }

        if (nextBlockIds.get(tableId) <= blockId) {
            nextBlockIds.put(tableId, blockId + 1);
        }

        blocks.put(blockId, new Block(blockId, blockSize));
    }

    private Integer addBlock(final Integer tableId) {
        Integer nextBlockId = getNextBlockId(tableId);
        tableBlocks.get(tableId).put(nextBlockId, new Block(nextBlockId));

        return nextBlockId;
    }

    private Integer getNextBlockId(final Integer tableId) {
        //TODO test if this nextNext crap is at all necessary
        Integer nextBlockId = nextBlockIds.get(tableId);

        if (nextBlockId == null) {
            nextBlockId = 0;
        }

        Integer nextNextBlockId = nextBlockId + 1;

        nextBlockIds.put(tableId, nextNextBlockId);

        return nextBlockId;
    }
}
