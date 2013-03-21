package gt.cs4420.relationaldb.database.storage.block;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * TODO:
 * * Spanning blocks
 * * Figure out the best way to handle what determines the "size" of a block (currently an arbitrary unit)
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
        //TODO Make this more sophisticated with spanning blocks
        if (requestedSize > MAX_BLOCK_SIZE) {
            throw new IllegalArgumentException("At the moment, space cannot be allocated for data larger than: " + requestedSize);
        }

        Map<Integer, Integer> tableBlockSizes = blockSizes.get(tableId);

        if (tableBlockSizes == null) {
            tableBlockSizes = Maps.newHashMap();
            blockSizes.put(tableId, tableBlockSizes);
        }

        for (Integer blockId : tableBlockSizes.keySet()) {
            if (tableBlockSizes.get(blockId) + requestedSize <= MAX_BLOCK_SIZE) {
                tableBlockSizes.put(blockId, tableBlockSizes.get(blockId) + requestedSize);
                return blockId;
            }
        }

        Integer newBlockId = addBlock(tableId);
        tableBlockSizes.put(newBlockId, requestedSize);

        return newBlockId;
    }

    public int getBlockSize(final Integer tableId, final Integer blockId) {
        Integer blockSize = blockSizes.get(tableId).get(blockId);

        if (blockSize == null) {
            throw new IllegalArgumentException("No block with ID: " + blockId + " has been allocated for table with ID: " + tableId);
        }

        return blockSize;
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
