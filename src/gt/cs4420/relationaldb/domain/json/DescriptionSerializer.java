package gt.cs4420.relationaldb.domain.json;

import gt.cs4420.relationaldb.domain.Table;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Set;

public class DescriptionSerializer implements JsonSerializer<Table> {

    private AttributeSerializer attributeSerializer;

    @Override
    public JSONObject serialize(Table object) {
        JSONObject json = new JSONObject();

        json.put("id", object.getId());
        json.put("name", object.getName());
        json.put("attributes", attributeSerializer.serialize(object.getAttributes()));

        return json;
    }

    @Override
    public Table deserialize(JSONObject json) {
        return null;
    }

    public JSONObject serialize(Set<Table> tables) {
        JSONArray tableArray = new JSONArray();

        for (Table table : tables) {
            tableArray.put(serialize(table));
        }

        JSONObject json = new JSONObject();
        json.put("tables", tableArray);
        return json;
    }

}
