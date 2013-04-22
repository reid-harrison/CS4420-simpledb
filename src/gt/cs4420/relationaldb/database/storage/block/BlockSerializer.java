package gt.cs4420.relationaldb.database.storage.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.json.AttributeSerializer;
import gt.cs4420.relationaldb.domain.json.JsonSerializer;
import gt.cs4420.relationaldb.domain.json.RowSerializer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;

public class BlockSerializer implements JsonSerializer<Block> {

    private AttributeSerializer attributeSerializer;
    private RowSerializer rowSerializer;

    public BlockSerializer() {
        attributeSerializer = new AttributeSerializer();
        rowSerializer = new RowSerializer();
    }

    @Override
    public JSONObject serialize(final Block block) {
        JSONObject json = new JSONObject();
        JSONArray blockArray = new JSONArray();

        for (int i = 0; i < block.getBlockData().size(); i++) {
            blockArray.put(i, rowSerializer.serialize(block.getBlockData().get(i)));
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

        List<Row> rows = Lists.newArrayList();

        for (int i = 0; i < dataArray.length(); i++) {
            Row rowData = rowSerializer.deserialize(dataArray.getJSONObject(i));
            rows.add(rowData);
        }

        block.setRowData(rows);

        return block;
    }

    public Block deserialize(final JSONObject json, final Set<Integer> cachedPrimaryKeys) {
        Block block = new Block();

        JSONObject blockJson = json.getJSONObject("block");

        block.setBlockSize(blockJson.getInt("size"));
        block.setBlockId(blockJson.getInt("blockId"));

        JSONArray dataArray = blockJson.getJSONArray("data");

        List<Row> rows = Lists.newArrayList();

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject rowJson = dataArray.getJSONObject(i);

            //Don't pull cached items off disk
            if (cachedPrimaryKeys != null && cachedPrimaryKeys.contains(rowJson.getInt("primaryKey"))) {
                continue;
            }

            Row rowData = rowSerializer.deserialize(dataArray.getJSONObject(i));
            rows.add(rowData);
        }

        block.setRowData(rows);

        return block;
    }

    public Row deserializeRow(final JSONObject json, final int blockIndex) {
        JSONObject blockJson = json.getJSONObject("block");
        JSONArray dataArray = blockJson.getJSONArray("data");

        return rowSerializer.deserialize(dataArray.getJSONObject(blockIndex));
    }

    public JSONObject serializeBlockMetaData(final List<Block> metaBlocks) {
        JSONObject metaJson = new JSONObject();
        JSONArray metaArray = new JSONArray();

        for (Block block : metaBlocks) {
            JSONObject blockJson = new JSONObject();

            blockJson.put("blockId", block.getBlockId());
            blockJson.put("size", block.getBlockSize());

            metaArray.put(blockJson);
        }

        metaJson.put("meta", metaArray);
        return metaJson;
    }

    public List<Block> deserializeBlockMetaData(final JSONObject json) {
        List<Block> blocks = Lists.newArrayList();

        JSONArray metaArray = json.getJSONArray("meta");

        for (int i = 0; i < metaArray.length(); i++) {
            JSONObject blockData = metaArray.getJSONObject(i);
            Block block = new Block();

            block.setBlockId(blockData.getInt("blockId"));
            block.setBlockSize(blockData.getInt("size"));

            blocks.add(block);
        }

        return blocks;
    }

    /**
     * Serializes the given Block and merges it with a prior block JSONObject.
     *
     * @param json
     * @param block
     * @return
     */
    public JSONObject mergeSerialize(final JSONObject json, final Block block) {
        JSONObject mergedJson = new JSONObject();
        JSONArray mergedArray = new JSONArray();
        List<Row> mergeRows = block.getBlockData();
        int mergedRowCount = 0;

        JSONObject previousBlockJson = json.getJSONObject("block");
        JSONArray previousArray = previousBlockJson.getJSONArray("data");

        List<Integer> mergePrimaryKeys = Lists.newArrayList();

        for (Row row : mergeRows) {
            mergePrimaryKeys.add(row.getPrimaryKey());
        }

        for (int i = 0; i < previousArray.length(); i++) {
            JSONObject previousRow = previousArray.getJSONObject(i);
            Integer currentPreviousPrimaryKey = previousRow.getInt("primaryKey");

            if (mergePrimaryKeys.contains(currentPreviousPrimaryKey)) {
                mergedArray.put(i, rowSerializer.serialize(mergeRows.get(mergedRowCount)));
                mergedRowCount++;
            } else {
                mergedArray.put(i, previousArray.get(i));
            }
        }

        while (mergedRowCount < mergeRows.size()) {
            mergedArray.put(rowSerializer.serialize(mergeRows.get(mergedRowCount)));
            mergedRowCount++;
        }

        JSONObject mergedBlockJson = new JSONObject();
        mergedBlockJson.put("blockId", block.getBlockId());
        mergedBlockJson.put("size", block.getBlockSize());
        mergedBlockJson.put("data", mergedArray);

        mergedJson.put("block", mergedBlockJson);

        return mergedJson;
    }

}
