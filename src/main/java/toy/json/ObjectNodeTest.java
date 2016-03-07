package toy.json;

import java.io.IOException;
import java.util.Iterator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

/**
 * ObjectNodeTest
 *
 * @author chi.chen
 * @date 16-3-7
 * @time 下午8:26
 */
public class ObjectNodeTest {

    public static void main(String[] args) {
        String testStr = "{\"results\":[{\"objectID\":357,\"geoPoints\":[{\"x\":504604.59802246094,\"y\":305569.9150390625}]},{\"objectID\":358,\"geoPoints\":[{\"x\":504602.2680053711,\"y\":305554.43603515625}]}]}";

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();

        try {
            JsonNode node = objectMapper.readTree(testStr);
            Iterator<String> keys = node.getFieldNames();

            while(keys.hasNext()) {
                String fieldName = keys.next();
                JsonNode valueNode = node.path(fieldName);

                objectNode.put(fieldName, valueNode);
            }

            ObjectNode rightNode = (ObjectNode) objectNode.get("results").get(0).get("geoPoints").get(0);
            rightNode.put("x", 1.5);

            if (node instanceof ObjectNode) {
                ObjectNode anotherObjectNode = (ObjectNode) node;

                System.out.println(anotherObjectNode.toString());
            }

            System.out.println(objectNode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}
