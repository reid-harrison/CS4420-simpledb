package gt.cs4420.relationaldb.database.storage.block;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * TODO:
 * * A block meta-data file needs to be kept with sizes and stuff
 * * Figure out the best way to handle what determines the "size" of a block (currently an attribute count)
 * * Keep data in sorted order by primary key
 */
public class BlockManager {

    //The maximum amount of attributes to store in a single block
    private final int MAX_BLOCK_SIZE = 16;

    //Mapping from table ID to a map of block IDs to current block size
    private Map<Integer, Map<Integer, Integer>> blockSizes;
    private Map<Integer, Integer> nextBlockIds;

    public BlockManager() {
        blockSizes = Maps.newHashMap();
        nextBlockIds = Maps.newHashMap();
    }

    /**
     * Allocates space in an available block of the given table ID and returns the ID of the assigned block.
     *
     * @param tableId Integer ID for the table in which space is needed
     * @param requestedSize the amount of space needed
     * @return Integer the block ID in which space was allocated
     */
    public Integer allocateBlockSpace(final Integer tableId, final int requestedSize) {
        Map<Integer, Integer> tableBlockSizes = blockSizes.get(tableId);

        if (tableBlockSizes == null) {
            tableBlockSizes = Maps.newHashMap();
            blockSizes.put(tableId, tableBlockSizes);
        }

        //If the requested size is small enough, it will share a block with other data
        if (requestedSize < MAX_BLOCK_SIZE) {

            //Find the first block with enough space to be allocated
            for (Integer blockId : tableBlockSizes.keySet()) {
                if (tableBlockSizes.get(blockId) + requestedSize <= MAX_BLOCK_SIZE) {
                    tableBlockSizes.put(blockId, tableBlockSizes.get(blockId) + requestedSize);
                    return blockId;
                }
            }
        }

        //No available blocks, allocate a new one
        Integer newBlockId = addBlock(tableId);
        tableBlockSizes.put(newBlockId, requestedSize);

        return newBlockId;
    }

    public Integer getBlockSize(final Integer tableId, final Integer blockId) {
        Integer blockSize = blockSizes.get(tableId).get(blockId);

        if (blockSize == null) {
            throw new IllegalArgumentException("No block with ID: " + blockId + " has been allocated for table with ID: " + tableId);
        }

        return blockSize;
    }

    public void setBlockSize(final Integer tableId, final Integer blockId, final Integer blockSize) {
        Map<Integer, Integer> tableBlockSizes = blockSizes.get(tableId);

        if (tableBlockSizes == null) {
            tableBlockSizes = Maps.newHashMap();
            blockSizes.put(tableId, tableBlockSizes);
        }

        if (nextBlockIds.get(tableId) <= blockId) {
            nextBlockIds.put(tableId, blockId + 1);
        }

        tableBlockSizes.put(blockId, blockSize);
    }

    private Integer addBlock(final Integer tableId) {
        Integer nextBlockId = getNextBlockId(tableId);
        blockSizes.get(tableId).put(nextBlockId, 0);

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
