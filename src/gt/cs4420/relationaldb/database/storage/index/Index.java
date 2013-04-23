package gt.cs4420.relationaldb.database.storage.index;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Index {

    /**
     * Returns the set of primary keys that this index tracks.
     *
     * @return Set<Integer>
     */
    Set<Integer> getPrimaryKeySet();

    /**
     * Returns the set of block IDs that this index tracks.
     *
     * @return Set<Integer>
     */
    Set<Integer> getBlockIdSet();

    /**
     * Returns the ID for the block where the row with the given primary key resides on disk.
     *
     * @param primaryKey
     * @return Integer
     */
    Integer getBlockId(Integer primaryKey);

    /**
     * Adds the given primary key -> block id pair to the index. The block index is used to know where on the block
     * the row is stored.
     *
     * @param primaryKey
     * @param blockId
     * @param blockIndex
     */
    void addIndexEntry(Integer primaryKey, Integer blockId, Integer blockIndex);

    /**
     * Removes the given primary key from the index.
     *
     * @param primaryKey
     */
    void removeIndexEntry(Integer primaryKey);

    /**
     * Returns the mapping of block ids to a list of dirty primary keys.
     *
     * @return Map<Integer, List<Integer>>
     */
    Map<Integer, List<Integer>> getDirtyPrimaryKeys();

    /**
     * Adds the given primary key to the set of dirty keys for the given block.
     *
     * @param blockId
     * @param primaryKey
     */
    void addDirtyPrimaryKey(Integer blockId, Integer primaryKey);

    /**
     * Removes the given primary key from the set of dirty primary keys for the given block.
     *
     * @param blockId
     * @param primaryKey
     */
    void removeDirtyPrimaryKey(Integer blockId, Integer primaryKey);

    /**
     * Clears the current set of dirty primary keys. This should be called when the cache has been cleared of dirty data.
     */
    void clearAllDirtyPrimaryKeys();

    /**
     * Returns the index of block IDs to the List of primary keys they contain.
     *
     * @return Map<Integer, List<Integer>>
     */
    Map<Integer, List<Integer>> getReverseIndex();

    /**
     * Returns the index of the row with the given primary key within its block. For example, the first primary key in
     * the block will have a block index of 0 and the last primary key will be at block index (totalRowCount - 1).
     *
     * @param primaryKey
     * @return int
     */
    int getBlockIndex(Integer primaryKey);

    /**
     * Returns the next index available for a given block.
     *
     * @param blockId
     * @return int
     */
    int getNextBlockIndex(Integer blockId);

    /**
     * Returns whether or not of this index holds an entry for the given primary key.
     *
     * @param primaryKey
     * @return boolean
     */
    boolean primaryKeyExists(Integer primaryKey);

}
