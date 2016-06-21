package toy.json.util;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json工具类
 *
 * Created by cc on 16/6/19.
 */
public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static <T> T jsonToObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();

        T result;
        try {
            result = objectMapper.readValue(str, new TypeReference<T>() {});
        } catch (IOException e) {
            logger.error("Json反序列化异常，str={}", str);
            return null;
        }

        return result;
    }

    public static String objectToJson(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();

        String result;
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            logger.error("Json序列化异常，obj={}", obj);
            return StringUtils.EMPTY;
        }

        return result;
    }
}
