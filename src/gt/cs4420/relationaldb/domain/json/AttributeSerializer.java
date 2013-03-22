package gt.cs4420.relationaldb.domain.json;

import com.google.common.base.Strings;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class AttributeSerializer implements JsonSerializer<Attribute> {

    @Override
    public JSONObject serialize(Attribute object) {
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
    public Attribute deserialize(JSONObject json) {
        Attribute attribute = new Attribute();

        attribute.setName(json.getString("name"));
        attribute.setType(DataType.valueOf(json.getString("type")));

        return attribute;
    }

    public Attribute[] deserialize(JSONArray jsonArray) {
        Attribute[] attributes = new Attribute[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            attributes[i] = deserialize(jsonArray.getJSONObject(i));
        }

        return attributes;
    }
}
