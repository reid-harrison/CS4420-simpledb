package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.database.storage.index.Index;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.database.storage.index.IndexSerializer;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.json.TableSerializer;
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

    private String dbRootDirectory = "database/";

    private File descriptionFile;

    private JsonFileWriter fileWriter;
    private JsonFileReader fileReader;

    private TableSerializer tableSerializer;
    private BlockSerializer blockSerializer;
    private IndexSerializer indexSerializer;

    public FileManager() {
        fileWriter = new JsonFileWriter();
        fileReader = new JsonFileReader();

        tableSerializer = new TableSerializer();

        initDescription();
    }

    private void initDescription() {
        descriptionFile = new File(dbRootDirectory + "description.json");
        //descriptionFile.mkdirs();

        try {
            descriptionFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Table> importDescriptions() {
        Set<Table> tables = Sets.newHashSet();

        //TODO Implement importDescriptions
        return tables;
    }

    public void exportDescriptions(final Set<Table> tables) {
        fileWriter.write(descriptionFile, tableSerializer.serialize(tables));
    }

    public void importTableBlock() {
        //TODO Implement importTableBlock
    }

    public void exportTableBlock(final Integer tableId, final Integer blockId, final int blockSize, final List<Map<Attribute, Object>> blockData) {
        File blockFile = new File(dbRootDirectory + tableId + "/blocks/" + blockId + ".json");

        try {
            blockFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileWriter.write(blockFile, blockSerializer.serializeWithSize(blockData, blockSize));
    }

    /**
     * Imports the indexes for the Indexes kept by the provided IndexManager from disk and populates the IndexManager.
     *
     * @param indexManager IndexManager with the desired indexes already instantiated
     */
    public void importIndexes(final IndexManager indexManager) {
        for (Integer tableId : indexManager.getTableIdSet()) {
            File indexFile = new File(dbRootDirectory + tableId + "/index.json");

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
            File indexFile = new File(dbRootDirectory + tableId + "/index.json");

            try {
                indexFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONObject indexJson = indexSerializer.serialize(indexManager.getIndex(tableId));
            fileWriter.write(indexFile, indexJson);
        }
    }
}
