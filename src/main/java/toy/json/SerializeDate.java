/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.ApiResult;

import java.util.Date;

/**
 * writeValueAsString会把Date序列化为milliseconds的形式
 *
 * @author chichen  Date: 16-4-7 Time: 下午7:56
 */
public class SerializeDate {

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);

        ObjectMapper objectMapper = new ObjectMapper();
        ApiResult apiResult = ApiResult.succ(date);
        try {
            String jsonStr = objectMapper.writeValueAsString(apiResult);
            System.out.println(jsonStr);

            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            String dateStr = jsonNode.path("data").asText();
            System.out.println(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
