package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.json.AttributeSerializer;
import gt.cs4420.relationaldb.domain.json.JsonSerializer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

class BlockSerializer implements JsonSerializer<Block> {

    private AttributeSerializer attributeSerializer;

    public BlockSerializer() {
        attributeSerializer = new AttributeSerializer();
    }

    @Override
    public JSONObject serialize(final Block block) {
        JSONObject json = new JSONObject();
        JSONArray blockArray = new JSONArray();

        for (int i = 0; i < block.getBlockData().size(); i++) {
            blockArray.put(i, attributeSerializer.serialize(block.getBlockData().get(i)));
        }

        JSONObject blockJson = new JSONObject();
        blockJson.put("blockId", block.getBlockId());
        blockJson.put("size", block.getBlockSize());
        blockJson.put("data", blockArray);

        json.put("block", blockJson);
        return json;
    }

    @Override
    public Block deserialize(final JSONObject json) {
        Block block = new Block();

        JSONObject blockJson = json.getJSONObject("block");

        block.setBlockSize(blockJson.getInt("size"));
        block.setBlockId(blockJson.getInt("blockId"));

        JSONArray dataArray = blockJson.getJSONArray("data");

        List<Map<Attribute, Object>> blockData = Lists.newArrayList();

        for (int i = 0; i < dataArray.length(); i++) {
            Map<Attribute, Object> attrs = attributeSerializer.deserializeWithData(dataArray.getJSONArray(i));
            blockData.add(attrs);
        }

        block.setBlockData(blockData);

        return block;
    }

}
