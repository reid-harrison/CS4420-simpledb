package gt.cs4420.relationaldb.database.storage.file;

import org.json.JSONObject;

import java.io.*;
import java.text.ParseException;

public class JsonFileReader {

    private BufferedReader reader;

    public JSONObject read(final File file) {
        if (!file.exists() || file.length() <= 0) {
            return new JSONObject();
        }

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        StringBuffer jsonString = new StringBuffer();
        String lineString = null;

        try {
            while ((lineString = reader.readLine()) != null) {
                jsonString.append(lineString);
            }
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }

        JSONObject json = null;

        try {
            json = new JSONObject(jsonString.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}
