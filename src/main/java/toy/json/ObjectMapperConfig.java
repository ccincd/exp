package toy.json;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import toy.json.bean.Person;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Maps;

/**
 * ObjectMapperConfig
 *
 * @author chi.chen
 * @date 16-2-29
 * @time 下午8:21
 */
public class ObjectMapperConfig {

    public static void main(String[] args) {
        Person jack = new Person("jack", 32, 1);
        Map<String, String> nameAddress = Maps.newHashMap();
        nameAddress.put("jack", "wall street.");
        nameAddress.put("rose", null);

        ObjectMapper codeHouse = new ObjectMapper();
        com.fasterxml.jackson.databind.ObjectMapper fasterXml = new com.fasterxml.jackson.databind.ObjectMapper();

        codeHouse.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
        // @Wrong
        // codeHouse.configure(JsonSerialize.Inclusion.NON_NULL, true);

        // @Deprecated 可以用注解的方式
        // codeHouse.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        // @Deprecated
        // codeHouse.getSerializationConfig().disable(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES);

        fasterXml.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        try {
            System.out.println(codeHouse.writeValueAsString(jack));
            System.out.println(fasterXml.writeValueAsString(jack));

            System.out.println(codeHouse.writeValueAsString(nameAddress));
            System.out.println(fasterXml.writeValueAsString(nameAddress));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
