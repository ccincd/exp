package toy.basic;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * MapTest
 *
 * @author chi.chen
 * @date 16-3-18
 * @time 下午3:11
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        map.put("hi", "there");
        String value = map.get("hello");
        if (value == null) {
            System.out.println("null");
        }
    }
}
