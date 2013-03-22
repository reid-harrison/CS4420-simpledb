package gt.cs4420.relationaldb.domain.json;

import gt.cs4420.relationaldb.domain.Description;
import org.json.JSONObject;

public class DescriptionSerializer implements JsonSerializer<Description> {

    private AttributeSerializer attributeSerializer;

    public DescriptionSerializer() {
        attributeSerializer = new AttributeSerializer();
    }

    @Override
    public JSONObject serialize(Description description) {
        JSONObject json = new JSONObject();

        json.put("attributes", attributeSerializer.serialize(description.getAttributes()));

        return json;
    }

    @Override
    public Description deserialize(JSONObject json) {
        //TODO deserialize
        return null;
    }

}
