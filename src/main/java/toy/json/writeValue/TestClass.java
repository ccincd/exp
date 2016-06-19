package toy.json.writeValue;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * TestClass
 *
 * Created by cc on 16/6/19.
 */
public class TestClass {

    public static void main(String[] args) {
        String str = "[\"hi\",\"there\",\"~\"]";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<String> list = objectMapper.readValue(str, new TypeReference<List<String>>() {});
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
