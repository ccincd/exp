package toy.json;

import controller.ApiResult;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * WithStringJsonData
 *
 * Created by cc on 16/6/14.
 */
public class WithStringJsonData {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonStr = "{\"error\":\"CASE_INFO_QUERY_FAILED\",\"message\":\"查询平面布置失败\",\"succ\":false,\"status\":201,\"data\":null}";
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            String jsonNodeStr = jsonNode.toString();
            ApiResult apiResult = ApiResult.succ(jsonNodeStr);
            ApiResult apiResultJsonNode = ApiResult.succ(jsonNode);

            String apiResultStr = objectMapper.writeValueAsString(apiResult);
            System.out.println(apiResultStr);

            String apiResultNodeStr = objectMapper.writeValueAsString(apiResultJsonNode);
            System.out.println(apiResultNodeStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
