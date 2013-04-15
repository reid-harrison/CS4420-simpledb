package gt.cs4420.relationaldb.domain.json;

import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Table;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Set;

public class TableSerializer implements JsonSerializer<Table> {

    private DescriptionSerializer descSerializer;

    public TableSerializer() {
        descSerializer = new DescriptionSerializer();
    }

    @Override
    public JSONObject serialize(Table object) {
        JSONObject json = new JSONObject();

        json.put("id", object.getId());
        json.put("name", object.getName());
        json.put("description", descSerializer.serialize(object.getDescription()));

        return json;
    }

    @Override
    public Table deserialize(JSONObject json) {
        if (json == null || json.length() == 0) {
            return null;
        }

        Table table = new Table();

        table.setId(json.getInt("id"));
        table.setName(json.getString("name"));
        table.setDescription(descSerializer.deserialize(json.getJSONObject("description")));

        return table;
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

    public Set<Table> deserializeTableSet(final JSONObject jsonTables) {
        Set<Table> tables = Sets.newHashSet();

        if (jsonTables.length() <= 0) {
            return Sets.newHashSet();
        }

        JSONArray tableArray = jsonTables.getJSONArray("tables");

        for (int i = 0; i < tableArray.length(); i++) {
            JSONObject tableJson = null;

            try {
                tableJson = new JSONObject(tableArray.get(i).toString());
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }

            Table table = deserialize(tableJson);

            tables.add(table);
        }

        return tables;
    }
}
