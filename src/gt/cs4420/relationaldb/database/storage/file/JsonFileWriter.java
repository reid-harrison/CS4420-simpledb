package gt.cs4420.relationaldb.database.storage.file;


import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {

    private FileWriter writer;

    public boolean write(final File file, final JSONObject json) {
        try {
            writer = new FileWriter(file);

            writer.write(json.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
