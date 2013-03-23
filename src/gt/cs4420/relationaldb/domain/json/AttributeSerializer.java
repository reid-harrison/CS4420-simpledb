package gt.cs4420.relationaldb.domain.json;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * TODO:
 * -Serialize attribute ids?
 */
public class AttributeSerializer implements JsonSerializer<Attribute> {

    @Override
    public JSONObject serialize(final Attribute object) {
        JSONObject json = new JSONObject();

        json.put("name", object.getName());
        json.put("type", object.getType().getTypeString());

        return json;
    }

    public JSONArray serialize(final Attribute[] attributes) {
        JSONArray array = new JSONArray();

        for (Attribute attr : attributes) {
            array.put(serialize(attr));
        }

        return array;
    }

    @Override
    public Attribute deserialize(final JSONObject json) {
        Attribute attribute = new Attribute();

        attribute.setName(json.getString("name"));
        attribute.setType(DataType.valueOf(json.getString("type")));

        return attribute;
    }

    /**
     * Deserializes an array of Attribute objects for importing Descriptions.
     *
     * @param jsonArray
     * @return Attribute[] array of Attribute descriptions (no data)
     */
    public Attribute[] deserialize(final JSONArray jsonArray) {
        Attribute[] attributes = new Attribute[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            attributes[i] = deserialize(jsonArray.getJSONObject(i));
        }

        return attributes;
    }

}
