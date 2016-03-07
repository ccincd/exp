package toy.json;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

/**
 * SimplerObjectNodeTest
 *
 * @author chi.chen
 * @date 16-3-7
 * @time 下午9:04
 */
public class SimplerObjectNodeTest {

    public static void main(String[] args) {
        String testStr = "{\"results\":[{\"objectID\":357,\"geoPoints\":[{\"x\":504604.59802246094,\"y\":305569.9150390625}]},{\"objectID\":358,\"geoPoints\":[{\"x\":504602.2680053711,\"y\":305554.43603515625}]}]}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ObjectNode node = (ObjectNode) objectMapper.readTree(testStr);

            ObjectNode rightNode = (ObjectNode) node.get("results").get(0).get("geoPoints").get(0);
            rightNode.put("x", 1.5);

            System.out.println(node.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}
