package toy.json;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import toy.guava.Person;

/**
 * NullTest
 *
 * @author chi.chen
 * @date 16-3-1
 * @time 下午6:12
 */
public class NullTest {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;
        try {
            objectMapper.readValue(str, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
