package toy.guava;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

/**
 * PredicatesTest
 *
 * @author chi.chen
 * @date 16-3-14
 * @time 上午11:17
 */
public class PredicatesTest {

    protected static List<Person> persons;

    static {
        persons = Lists.newArrayList();
        persons.add(new Person("jackson", 1, 35));
        persons.add(new Person("rose", 2, 25));
        persons.add(new Person("ada wong", 2, 50));
        persons.add(new Person("christina", 2, 16, "wall street"));
    }

    protected static Predicate<Person> filterName = new Predicate<Person>() {
        @Override
        public boolean apply(Person input) {
            if (input == null || StringUtils.isEmpty(input.getName())) {
                return false;
            }

            return input.getName().length() > 4;
        }
    };

    protected static Predicate<Person> filterAge = new Predicate<Person>() {
        @Override
        public boolean apply(Person input) {
            if (input == null) {
                return false;
            }

            return input.getAge() > 0 && input.getAge() < 40;
        }
    };

    protected static Predicate<Person> filterTeenAge = new Predicate<Person>() {
        @Override
        public boolean apply(Person input) {
            if (input == null) {
                return false;
            }

            return input.getAge() > 0 && input.getAge() < 19;
        }
    };

    protected static Predicate<Person> filterAddr = new Predicate<Person>() {
        @Override
        public boolean apply(Person input) {
            return input != null && StringUtils.isNotBlank(input.getAddress());
        }
    };

    public static void testAnd() {
        for (Person person : persons) {
            boolean flag = Predicates.and(filterName, filterAge).apply(person);

            if (flag) {
                System.out.println(person);
            }
        }
    }

    /**
     * 断言里的and和or可以嵌套使用，类似于(A && (B || C))
     */
    public static void testAndOr() {
        for (Person person : persons) {
            boolean flag = Predicates.and(filterName, Predicates.or(filterTeenAge, filterAddr)).apply(person);

            if (flag) {
                System.out.println(person);
            }
        }
    }

    public static void main(String[] args) {
        testAndOr();
    }
}
