package gt.cs4420.relationaldb.database.storage.file;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.json.JsonSerializer;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

class BlockSerializer implements JsonSerializer<List<Map<Integer, Map<Attribute, Object>>>> {

    @Override
    public JSONObject serialize(List<Map<Integer, Map<Attribute, Object>>> blockData) {
        //TODO Implement serialize
        return null;
    }

    @Override
    public List<Map<Integer, Map<Attribute, Object>>> deserialize(JSONObject json) {
        //TODO Implement deserialize
        return null;
    }
}
