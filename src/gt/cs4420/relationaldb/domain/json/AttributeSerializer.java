package gt.cs4420.relationaldb.domain.json;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

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

    public JSONArray serialize(final Map<Attribute, Object> attributes) {
        JSONArray json = new JSONArray();

        for (Attribute attr : attributes.keySet()) {
            json.put(serialize(attr, attributes.get(attr)));
        }

        return json;
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

    public Map<Attribute, Object> deserializeWithData(final JSONArray jsonArray) {
        Map<Attribute, Object> attributeData = Maps.newHashMap();

        for (int i = 0; i < jsonArray.length(); i++) {
            attributeData.putAll(deserializeWithData(jsonArray.getJSONObject(i)));
        }

        return attributeData;
    }

    /**
     * Deserializes a single attribute with data.
     *
     * @param jsonObject
     * @return Map<Attribute, Object> containing one item
     */
    public Map<Attribute, Object> deserializeWithData(final JSONObject jsonObject) {
        Map<Attribute, Object> attributeMap = Maps.newHashMap();
        Attribute attr = new Attribute(jsonObject.keys().next().toString());

        attributeMap.put(attr, jsonObject.get(attr.getName()));
        return attributeMap;
    }

}
