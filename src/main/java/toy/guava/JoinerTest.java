package toy.guava;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

/**
 * JoinerTest
 *
 * @author chi.chen
 * @date 16-3-8
 * @time 上午10:09
 */
public class JoinerTest {

    public static void testMapJoiner() {
        Map<String, Integer> nameAges = Maps.newHashMap();

        nameAges.put("cc", 28);
        nameAges.put("dd", 26);
        nameAges.put("ee", 24);

        Joiner.MapJoiner mapJoiner = Joiner.on(";").withKeyValueSeparator("=");
        String joinResult = mapJoiner.join(nameAges);

        System.out.println(joinResult);
    }

    public static void main(String[] args) {
        testMapJoiner();
    }
}
