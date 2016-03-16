package toy.basic;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * IntDoubleInstanceOf
 *
 * @author chi.chen
 * @date 16-3-16
 * @time 下午8:20
 */
public class IntDoubleInstanceOf {

    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("i", 35);
        map.put("d", 420.56);

        if (map.get("i") instanceof Integer) {
            System.out.println("hi");
        }

        if (map.get("d") instanceof Double) {
            System.out.println("hello");
        }

        if (map.get("d") instanceof Integer) {
            System.out.println("oops");
        }
    }
}
