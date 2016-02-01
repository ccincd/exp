package json;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * JsonNode
 *
 * @author chi.chen
 * @date 16-1-25
 * @time 下午6:08
 */
public class JsonNodeTest {

    public static void main(String[] args) {
        String testStr = "{\"results\":[{\"objectID\":357,\"geoPoints\":[{\"x\":504604.59802246094,\"y\":305569.9150390625}]},{\"objectID\":358,\"geoPoints\":[{\"x\":504602.2680053711,\"y\":305554.43603515625}]}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(testStr);
            JsonNode resultNode = jsonNode.get("results");
            for (int i = 0; i < resultNode.size(); i++) {
                JsonNode pointNode = resultNode.get(i).get("geoPoints");
                for (int j = 0; j < pointNode.size(); j++) {
                    System.out.println("x: " + pointNode.get(j).get("x").getDoubleValue());
                    System.out.println("y: " + pointNode.get(j).get("y").getDoubleValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
