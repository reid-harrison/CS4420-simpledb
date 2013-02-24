package gt.cs4420.relationaldb.database.storage.file;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {

    private File file;
    private JSONObject json;

    private FileWriter writer;

    public JsonFileWriter(final File file, final JSONObject json) {
        this.file = file;
        this.json = json;

        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {

    }
}
