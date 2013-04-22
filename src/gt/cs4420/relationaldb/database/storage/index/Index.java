package gt.cs4420.relationaldb.database.storage.index;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Index {

    Set<Integer> getPrimaryKeySet();

    Set<Integer> getBlockIdSet();

    Integer getBlockId(Integer primaryKey);

    void addIndexEntry(Integer primaryKey, Integer blockId, Integer blockIndex);

    void removeIndexEntry(Integer primaryKey, Integer blockId, Integer blockIndex);

    Map<Integer, List<Integer>> getDirtyPrimaryKeys();

    void addDirtyPrimaryKey(Integer blockId, Integer primaryKey);

    void removeDirtyPrimaryKey(Integer blockId, Integer primaryKey);

    void clearAllDirtyPrimaryKeys();

    /**
     * Returns the index of block IDs to the List of primary keys they contain.
     *
     * @return Map<Integer, List<Integer>>
     */
    Map<Integer, List<Integer>> getReverseIndex();

    int getBlockIndex(Integer primaryKey);

    int getNextBlockIndex(Integer blockId);

    boolean primaryKeyExists(Integer primaryKey);

}
