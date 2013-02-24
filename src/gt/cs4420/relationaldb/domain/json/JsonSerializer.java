package gt.cs4420.relationaldb.domain.json;

import org.json.JSONObject;

public interface  JsonSerializer<O> {

    JSONObject serialize(O object);

    O deserialize(JSONObject json);

}
