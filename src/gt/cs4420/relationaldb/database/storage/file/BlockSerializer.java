package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.json.AttributeSerializer;
import gt.cs4420.relationaldb.domain.json.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

class BlockSerializer implements JsonSerializer<List<Map<Attribute, Object>>> {

    private AttributeSerializer attributeSerializer;

    public BlockSerializer() {
        attributeSerializer = new AttributeSerializer();
    }

    @Override
    public JSONObject serialize(final List<Map<Attribute, Object>> blockData) {
        JSONObject json = new JSONObject();

        JSONArray blockArray = new JSONArray();

        for (int i = 0; i < blockData.size(); i++) {
            blockArray.put(i, attributeSerializer.serialize(blockData.get(i)));
        }

        json.put("block", blockArray);
        return json;
    }

    @Override
    public List<Map<Attribute, Object>> deserialize(final JSONObject json) {
        List<Map<Attribute, Object>> blockData = Lists.newArrayList();

        JSONArray blockArray = json.getJSONArray("block");

        for (int i = 0; i < blockArray.length(); i++) {
            Map<Attribute, Object> attrs = attributeSerializer.deserializeWithData(blockArray.getJSONArray(i));
            blockData.add(attrs);
        }

        //TODO do something with the block size
        int blockSize = json.getInt("size");

        return blockData;
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
