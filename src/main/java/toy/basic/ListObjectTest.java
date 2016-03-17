package toy.basic;

import java.util.List;
import com.google.common.collect.Lists;

/**
 * ListObjectTest
 *
 * @author chi.chen
 * @date 16-3-17
 * @time 上午11:54
 */
public class ListObjectTest {

    public static void main(String[] args) {
        List<Object> list = Lists.newArrayList();
        list.add(0.5);
        list.add(3);

        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
