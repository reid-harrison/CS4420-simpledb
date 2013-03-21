package gt.cs4420.relationaldb.database.storage.index;

import gt.cs4420.relationaldb.domain.json.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;

public class IndexSerializer implements JsonSerializer<Index> {

    @Override
    public JSONObject serialize(Index object) {
        //TODO Implement serialize
        return null;
    }

    @Override
    public Index deserialize(JSONObject json) {
        Index index = new Index();

        if (json.get("index") == null) {
            throw new IllegalArgumentException("Index JSON object must have a root key 'index'");
        }

        JSONArray indexEntries = json.getJSONArray("index");

        for (int i = 0; i < indexEntries.length(); i++) {
            JSONObject entry = null;

            try {
                entry = new JSONObject((String) indexEntries.get(i));
            } catch (final ParseException pe) {
                pe.printStackTrace();
            }

            Integer primaryKey = Integer.parseInt((String) entry.keys().next());
            Integer blockId = entry.getInt(primaryKey.toString());

            index.addIndexEntry(primaryKey, blockId);
        }

        return index;
    }
}
