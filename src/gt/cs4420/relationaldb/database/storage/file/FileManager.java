package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.json.TableSerializer;

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

    private TableSerializer tableSerializer;
    private BlockSerializer blockSerializer;

    public FileManager() {
        fileWriter = new JsonFileWriter();

        tableSerializer = new TableSerializer();

        initDescription();
    }

    private void initDescription() {
        descriptionFile = new File(dbRootDirectory + "description");
        //descriptionFile.mkdirs();

        try {
            descriptionFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Table> importDescriptions() {
        Set<Table> tables = Sets.newHashSet();

        return tables;
    }

    public void exportDescriptions(final Set<Table> tables) {
        fileWriter.write(descriptionFile, tableSerializer.serialize(tables));
    }

    public void exportTableBlock(final Integer tableId, final Integer blockId, final List<Map<Attribute, Object>> blockData) {
        File blockFile = new File(dbRootDirectory + tableId + "/" + blockId);

        try {
            blockFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileWriter.write(blockFile, blockSerializer.serialize(blockData));
    }
}
