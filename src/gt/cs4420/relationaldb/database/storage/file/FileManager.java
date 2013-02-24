package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Table;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FileManager {

    private String dbRootDirectory = "database/";

    private File descriptionFile;


    public FileManager() {
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
}
