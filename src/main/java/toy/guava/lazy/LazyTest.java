package toy.guava.lazy;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 懒加载机制
 *
 * Created by cc on 16/5/2.
 */
public class LazyTest {

    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1, 2, 5, 0);

        List<Integer> dividedNumbers = Lists.transform(numbers, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                // System.out.println("handling " + input);
                return 100 / input;
            }
        });

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dividedNumbersStr = objectMapper.writeValueAsString(dividedNumbers);
            System.out.println(dividedNumbersStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 遍历会执行apply
         */
        System.out.println(dividedNumbers);

        /**
         * get元素会执行apply
         */
        System.out.println(dividedNumbers.get(0));
        System.out.println(dividedNumbers.get(1));
    }
}
