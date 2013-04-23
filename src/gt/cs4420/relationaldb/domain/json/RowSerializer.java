package gt.cs4420.relationaldb.domain.json;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Row;
import org.json.JSONObject;

import java.util.Map;

public class RowSerializer implements JsonSerializer<Row> {

    @Override
    public JSONObject serialize(final Row row) {
        JSONObject rowJson = new JSONObject();

        if (row.getPrimaryKey() == null) {
            throw new IllegalArgumentException("Rows must have primary keys set to be serialized");
        }

        rowJson.put("primaryKey", row.getPrimaryKey());
        rowJson.put("attributes", serialize(row.getRowData()));

        return rowJson;
    }

    @Override
    public Row deserialize(final JSONObject json) {
        Row row = new Row();

        row.setPrimaryKey(json.getInt("primaryKey"));
        row.setRowData(deserializeAttributes(json.getJSONObject("attributes")));

        return row;
    }

    private Map<Attribute, Object> deserializeAttributes(final JSONObject jsonObject) {
        Map<Attribute, Object> attributes = Maps.newHashMap();

        while (jsonObject.keys().hasNext()) {
            String attrName = (String) jsonObject.keys().next();
            attributes.put(new Attribute(attrName), jsonObject.get(attrName));
        }

        return attributes;

    }

    private JSONObject serialize(Map<Attribute, Object> attributes) {
        JSONObject attrJson = new JSONObject();

        for (Attribute attr : attributes.keySet()) {
            attrJson.put(attr.getName(), attributes.get(attr));
        }

        return attrJson;
    }

    /**
     * Serializes an Attribute -> Object pair. The attribute's name is used as the key for the serialized value.
     * The DataType of the Attribute is not serialized.
     *
     * @param attribute
     * @param value
     * @return JSONObject
     */
    private JSONObject serialize(final Attribute attribute, final Object value) {
        JSONObject json = new JSONObject();
        String name = attribute.getName();

        if(Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name must be set for attribute: " + attribute.getName());
        }

        json.put(name, value);

        return json;
    }

}
