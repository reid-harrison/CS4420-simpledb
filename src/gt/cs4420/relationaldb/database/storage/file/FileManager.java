package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.json.DescriptionSerializer;
import gt.cs4420.relationaldb.domain.json.TableSerializer;

import java.io.File;
import java.io.IOException;
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
}
