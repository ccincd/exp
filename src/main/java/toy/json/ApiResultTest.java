package toy.json;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import controller.ApiResult;

/**
 * Created by cc on 16/3/17.
 */
public class ApiResultTest {

    public static void main(String[] args) {
        String jsonStr = "{\n" + "    \"data\":{\n" + "        \"hi\":\"there\",\n" + "        \"hello\":5\n"
                + "    },\n" + "    \"status\":0,\n" + "    \"message\":\"更详细准确的错误信息\"\n" + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ApiResult apiResult = objectMapper.readValue(jsonStr, ApiResult.class);

            System.out.println(apiResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
