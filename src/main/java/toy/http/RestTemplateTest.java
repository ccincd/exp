package toy.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateTest
 *
 * @author chi.chen
 * @date 16-2-22
 * @time 上午11:28
 */
public class RestTemplateTest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> params = new HashMap<String, Object>();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<Map>(params, headers);
        // restTemplate.postForObject("hi", entity, new TypeReference<Map<String, Object>>() {});

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readValue("hi", new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
