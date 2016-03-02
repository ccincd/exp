package toy.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * MissingNodeTest
 *
 * @author chi.chen
 * @date 16-3-2
 * @time 上午10:45
 */
public class MissingNodeTest {

    /*
     * { "results":[ { "objectID":357, "geoPoints":[ { "x":504604.59802246094, "y":305569.9150390625 } ] }, {
     * "objectID":358, "geoPoints":[ { "x":504602.2680053711, "y":305554.43603515625 } ] } ] }
     */

    public static void main(String[] args) {
        String testStr = "{\"results\":[{\"objectID\":357,\"geoPoints\":[{\"x\":504604.59802246094,\"y\":305569.9150390625}]},{\"objectID\":358,\"geoPoints\":[{\"x\":504602.2680053711,\"y\":305554.43603515625}]}]}";

        try {
            JsonNode rootNode = new ObjectMapper().readTree(testStr);

            JsonNode getNode = rootNode.get("data");
            JsonNode pathNode = rootNode.path("data");

            System.out.println(pathNode.asInt());
            System.out.println(getNode.asInt(-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
