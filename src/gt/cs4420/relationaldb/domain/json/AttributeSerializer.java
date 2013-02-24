package gt.cs4420.relationaldb.domain.json;

import gt.cs4420.relationaldb.domain.Attribute;
import org.json.JSONArray;
import org.json.JSONObject;

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
}
