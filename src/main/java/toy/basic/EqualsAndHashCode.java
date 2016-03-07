package toy.basic;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 如果将对象放入有序容器中还需要重写compareTo方法
 *
 * Created by cc on 16/3/7.
 */
public class EqualsAndHashCode {

    /**
     * Person只重写equals方法时,contains会依照equals方法而非对象内存地址进行比较
     */
    public static void testContainer() {
        List<Person> persons = Lists.newArrayList();

        persons.add(new Person(28, "cc"));
        boolean result = persons.contains(new Person(28, "cc"));
        System.out.println(result);
    }

    /**
     * 把对象当作key的情况
     *
     * 查找key值:
     * 1. 首先看hashCode是否相同,如果不同则key肯定不同
     * 2. 如果hashCode相同,则需要依据equals的结果来判断相同与否
     *
     * 先判断hashCode可以提高效率
     * 若把Person的equals注释掉,保留hashCode,则该测试方法将输出两个对象,使用HashSet的情况类似
     * 相反,若注释掉hashCode,保留equals,则该测试方法同样会输出两个对象
     */
    public static void testHashMap() {
        HashMap<Person, String> map = Maps.newHashMap();

        map.put(new Person(28, "cc"), "chi.chen");
        map.put(new Person(28, "cc"), "chen chi");

        System.out.println(map);
    }

    public static void main(String[] args) {
        // testContainer();
        testHashMap();
    }
}
