package toy.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.common.collect.Lists;

/**
 * StaticSerialTest
 *
 * @author chi.chen
 * @date 16-3-11
 * @time 下午2:13
 */
public class StaticSerialTest {

    /**
     * 静态成员不会参与序列化的过程
     */
    public static List<String> terms = Lists.newArrayList("本期", "上期", "去年同期");

    private String name;

    public StaticSerialTest(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        StaticSerialTest serialTest = new StaticSerialTest("cc");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String serialStr = objectMapper.writeValueAsString(serialTest);
            System.out.println(serialStr);

            System.out.println(terms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 要序列化的域应当有get函数
     */
    public String getName() {
        return name;
    }
}
