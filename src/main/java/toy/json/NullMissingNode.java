/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package toy.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import toy.basic.Person;

/**
 * @author chichen  Date: 16-4-12 Time: 下午2:48
 */
public class NullMissingNode {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(3);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(person);
            JsonNode jsonNode = objectMapper.readTree(jsonStr);

            boolean b1 = jsonNode.path("name").isMissingNode();
            boolean b2 = jsonNode.path("missing").isMissingNode();
            System.out.println(b1);
            System.out.println(b2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
