/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author chichen  Date: 16-3-29 Time: 下午4:41
 */
@SuppressWarnings("all")
public class JsonNodeForeach {

    public static void main(String[] args) {
        String jsonStr = "[\n" + "    {\n" + "        \"Json解析\":\"支持格式化高亮折叠1\",\n"
                + "        \"支持XML转换\":\"支持XML转换Json,Json转XML1\",\n" + "        \"Json格式验证\":\"更详细准确的错误信息1\"\n"
                + "    },\n" + "    {\n" + "        \"Json解析\":\"支持格式化高亮折叠2\",\n"
                + "        \"支持XML转换\":\"支持XML转换Json,Json转XML2\",\n" + "        \"Json格式验证\":\"更详细准确的错误信息2\"\n"
                + "    },\n" + "    {\n" + "        \"Json解析\":\"支持格式化高亮折叠3\",\n"
                + "        \"支持XML转换\":\"支持XML转换Json,Json转XML3\",\n" + "        \"Json格式验证\":\"更详细准确的错误信息3\"\n"
                + "    }\n" + "]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);

            /**
             * 遍历方式一
             */
            Iterator<JsonNode> someNodes = rootNode.getElements();
            while (someNodes.hasNext()) {
                System.out.println(someNodes.next().toString());
            }

            /**
             * 遍历方式二
             */
            Iterator<JsonNode> anotherNodes = rootNode.iterator();
            while (anotherNodes.hasNext()) {
                System.out.println(anotherNodes.next().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
