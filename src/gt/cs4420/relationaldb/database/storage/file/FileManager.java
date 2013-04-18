package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.database.storage.index.Index;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.database.storage.index.IndexSerializer;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.json.TableSerializer;
import gt.cs4420.relationaldb.domain.query.Constraint;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO:
 * -Lots of file access stuff
 */
public class FileManager {

    private final String DB_ROOT_DIRECTORY;

    private File descriptionFile;

    private JsonFileWriter fileWriter;
    private JsonFileReader fileReader;

    private TableSerializer tableSerializer;
    private BlockSerializer blockSerializer;
    private IndexSerializer indexSerializer;

    public FileManager(final String dbRootDirectory) {
        DB_ROOT_DIRECTORY = dbRootDirectory;

        fileWriter = new JsonFileWriter();
        fileReader = new JsonFileReader();

        tableSerializer = new TableSerializer();
        blockSerializer = new BlockSerializer();
        indexSerializer = new IndexSerializer();

        initDescription();
    }

    private void initDescription() {
        descriptionFile = new File(DB_ROOT_DIRECTORY + "/description.json");

        try {
            descriptionFile.getParentFile().mkdirs();
            descriptionFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Table> importDescriptions() {
        descriptionFile = new File(DB_ROOT_DIRECTORY + "/description.json");

        return tableSerializer.deserializeTableSet(fileReader.read(descriptionFile));
    }

    public void exportDescriptions(final Set<Table> tables) {
        fileWriter.write(descriptionFile, tableSerializer.serialize(tables));
    }

    /**
     * Imports of a List of Blocks that have their IDs and sizes populated.
     *
     * @param tableId
     * @return List<Block>
     */
    public List<Block> importBlockMetaData(final Integer tableId) {
        File blockMetaFile = new File(DB_ROOT_DIRECTORY + tableId + "/blocks/meta.json");

        if (!blockMetaFile.exists()) {
            return null;
        }

        return blockSerializer.deserializeBlockMetaData(fileReader.read(blockMetaFile));
    }

    public void exportBlockMetaData(final Integer tableId, final List<Block> metaBlocks) {
        File blockMetaFile = new File(DB_ROOT_DIRECTORY + tableId + "/blocks/meta.json");
        blockMetaFile.getParentFile().mkdirs();

        try {
            blockMetaFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileWriter.write(blockMetaFile, blockSerializer.serializeBlockMetaData(metaBlocks));
    }

    public Block importTableBlock(final Integer tableId, final Integer blockId, final Description tableDescription) {
        File blockFile = new File(DB_ROOT_DIRECTORY + tableId + "/blocks/" + blockId + ".json");

        if (!blockFile.exists()) {
            return null;
        }
       
        Block block = blockSerializer.deserialize(fileReader.read(blockFile));

        //Cast all row data appropriately
        for (Row row : block.getBlockData()) {
            Map<Attribute, Object> attributes = row.getRowData();
            Map<Attribute, Object> castedAttributes = Maps.newHashMapWithExpectedSize(block.getBlockData().size());

            for (Attribute attr : attributes.keySet()) {
                //Use the descriptions attribute listing since it includes data types
                Attribute descAttr = tableDescription.getAttribute(attr.getName());

                switch (descAttr.getType()) {
                    case STRING:
                        castedAttributes.put(attr, (String) attributes.get(attr));
                        break;
                    case INT:
                        castedAttributes.put(attr, (Integer) attributes.get(attr));
                        break;
                }
            }

            row.setRowData(castedAttributes);
        }

        return block;
    }

    public List<Row> importTableBlockWithConstraint(final Integer tableId, final Integer blockId, final Description tableDescription, final Constraint whereConstraint) {
        Block block = importTableBlock(tableId, blockId, tableDescription);

        BlockFilter filter = new BlockFilter(whereConstraint);

        return filter.filterRows(block);
    }

    public Row importRow(final Integer tableId, final Integer blockId, final int blockIndex) {
        File blockFile = new File(DB_ROOT_DIRECTORY + tableId + "/blocks/" + blockId + ".json");

        if (!blockFile.exists()) {
            return null;
        }

        return blockSerializer.deserializeRow(fileReader.read(blockFile), blockIndex);
    }

    /**
     * Fresh export of the given rows to the given block. Any data currently stored on disk in that block will be completely
     * overwritten with the given rows.
     *
     * @param tableId
     * @param blockId
     * @param blockSize
     * @param rows
     */
    public void exportTableBlock(final Integer tableId, final Integer blockId, final int blockSize, final List<Row> rows) {
        File blockFile = new File(DB_ROOT_DIRECTORY + tableId + "/blocks/" + blockId + ".json");
        blockFile.getParentFile().mkdirs();

        try {
            blockFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Block block = new Block(blockId, rows, blockSize);

        fileWriter.write(blockFile, blockSerializer.serialize(block));
    }

    /**
     * Merges the given List of Rows with those already stored in the Block on disk. Primary keys that exist on disk will
     * have their attribute data replaced by what is provided and new primary keys will be added to the end of the block.
     *
     * @param tableId
     * @param blockId
     * @param blockSize
     * @param rows
     */
    public void exportTableBlockMerge(final Integer tableId, final Integer blockId, final int blockSize, final List<Row> rows) {
        File blockFile = new File(DB_ROOT_DIRECTORY + tableId + "/blocks/" + blockId + ".json");
        blockFile.getParentFile().mkdirs();

        try {
            blockFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject previousBlockJson = fileReader.read(blockFile);

        Block newBlockData = new Block(blockId, rows, blockSize);

        fileWriter.write(blockFile, blockSerializer.mergeSerialize(previousBlockJson, newBlockData));
    }

    /**
     * Imports the indexes for the Indexes (by table ID) kept by the provided IndexManager from disk and populates the IndexManager.
     *
     * @param indexManager IndexManager with the desired indexes already instantiated
     */
    public void importIndexes(final IndexManager indexManager) {
        for (Integer tableId : indexManager.getTableIdSet()) {
            File indexFile = new File(DB_ROOT_DIRECTORY + tableId + "/" + "index.json");

            if (!indexFile.exists()) {
                continue;
            }

            JSONObject indexJson = fileReader.read(indexFile);
            Index index = indexSerializer.deserialize(indexJson);

            indexManager.addIndex(tableId, index);
        }
    }

    public void exportIndexes(final IndexManager indexManager) {
        for (Integer tableId : indexManager.getTableIdSet()) {
            File indexFile = new File(DB_ROOT_DIRECTORY + tableId + "/" + "index.json");
            indexFile.getParentFile().mkdirs();

            try {
                indexFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONObject indexJson = indexSerializer.serialize(indexManager.getIndex(tableId));
            fileWriter.write(indexFile, indexJson);
        }
    }

    public void removeTableRowData(final Integer tableId) {
        File tableRootDirectory = new File(DB_ROOT_DIRECTORY + tableId);

        try {
            FileUtils.deleteDirectory(tableRootDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
