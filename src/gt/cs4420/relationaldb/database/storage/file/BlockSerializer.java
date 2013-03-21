package gt.cs4420.relationaldb.database.storage.file;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.json.AttributeSerializer;
import gt.cs4420.relationaldb.domain.json.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

class BlockSerializer implements JsonSerializer<List<Map<Attribute, Object>>> {

    @Override
    public JSONObject serialize(final List<Map<Attribute, Object>> blockData) {
        JSONObject json = new JSONObject();
        AttributeSerializer attrSerializer = new AttributeSerializer();

        JSONArray blockArray = new JSONArray();

        for (int i = 0; i < blockData.size(); i++) {
            blockArray.put(i, attrSerializer.serialize(blockData.get(i)));
        }

        json.put("block", blockArray);
        return json;
    }

    @Override
    public List<Map<Attribute, Object>> deserialize(final JSONObject json) {
        //TODO Implement deserialize
        return null;
    }

    /**
     * Serializes the block data in the standard block format but also appends the size for easy reference later.
     *
     * @param blockData
     * @param blockSize
     * @return JSONObject
     */
    public JSONObject serializeWithSize(final List<Map<Attribute, Object>> blockData, final int blockSize) {
        return serialize(blockData).put("size", blockSize);
    }
}
