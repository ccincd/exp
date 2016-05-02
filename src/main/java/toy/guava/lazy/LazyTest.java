package toy.guava.lazy;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

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

        // 做一份拷贝来让懒加载立即生效
        // Lists.newArrayList(Lists.transform(...));

        try {
            /**
             * ImmutableList.copyOf makes a copy unless it is copying a list that is already an ImmutableList.
             */
            List<Integer> immutableCopyOfDividedNumbers = ImmutableList.copyOf(dividedNumbers);
            System.out.println(immutableCopyOfDividedNumbers);
        } catch (Exception e) {
            System.out.println("hi, there");
        }

        /*ObjectMapper objectMapper = new ObjectMapper();
        try {
            String dividedNumbersStr = objectMapper.writeValueAsString(dividedNumbers);
            System.out.println(dividedNumbersStr);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

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
