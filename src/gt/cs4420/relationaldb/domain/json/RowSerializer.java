package gt.cs4420.relationaldb.domain.json;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Row;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class RowSerializer implements JsonSerializer<Row> {

    @Override
    public JSONObject serialize(Row object) {
        //TODO Implement serialize
        return null;
    }

    @Override
    public Row deserialize(JSONObject json) {
        return null;
    }

    public Row deserialize(final JSONArray jsonArray) {
        Row row = new Row();
        Map<Attribute, Object> rowData = Maps.newHashMap();

        for (int i = 0; i < jsonArray.length(); i++) {
            rowData.putAll(deserializeWithData(jsonArray.getJSONObject(i)));
        }

        row.setRowData(rowData);

        return row;
    }

    /**
     * Deserializes a single attribute with data.
     *
     * @param jsonObject
     * @return Map<Attribute, Object> containing one item
     */
    private Map<Attribute, Object> deserializeWithData(final JSONObject jsonObject) {
        Map<Attribute, Object> attributeMap = Maps.newHashMap();
        Attribute attr = new Attribute(jsonObject.keys().next().toString());

        attributeMap.put(attr, jsonObject.get(attr.getName()));
        return attributeMap;
    }

    /**
     * Serializes an Attribute -> Object pair. The attribute's name is used as the key for the serialized value.
     * The DataType of the Attribute is not serialized.
     *
     * @param attribute
     * @param value
     * @return JSONObject
     */
    public JSONObject serialize(final Attribute attribute, final Object value) {
        JSONObject json = new JSONObject();
        DataType type = attribute.getType();
        String name = attribute.getName();

        if (type == null) {
            throw new IllegalArgumentException("DataType cannot be null for attribute: " + attribute.getName());
        }

        if(Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name must be set for attribute: " + attribute.getName());
        }

        //TODO This might not be necessary
        switch (type) {
            case INT:
                json.put(name, (Integer) value);
                break;
            case STRING:
                json.put(name, (String) value);
                break;
        }

        return json;
    }

}
