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

    @Override
    public Attribute deserialize(JSONObject json) {
        //TODO deserialize
        return null;
    }

    public JSONArray serialize(final Attribute[] attributes) {
        JSONArray array = new JSONArray();

        for (Attribute attr : attributes) {
            array.put(serialize(attr));
        }

        return array;
    }

    public JSONArray serialize(final Map<Attribute, Object> attributes) {
        //TODO Implement attr serialization
        return null;
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
}
