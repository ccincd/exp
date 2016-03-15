package toy.json.generator;

import java.io.IOException;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * BaseGenerator
 *
 * @author chi.chen
 * @date 16-3-15
 * @time 下午2:07
 */
public class BaseGenerator {

    @JsonIgnore
    protected static ObjectMapper objectMapper;

    public BaseGenerator() {
        objectMapper = new ObjectMapper();
    }

    public static String serilize(Object toSerial) {
        try {
            return objectMapper.writeValueAsString(toSerial);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String serilize() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
