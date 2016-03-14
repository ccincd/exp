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

    public static void main(String[] args) {
        List<Person> persons = Lists.newArrayList();
        persons.add(new Person("jackson", 1, 35));
        persons.add(new Person("rose", 2, 25));
        persons.add(new Person("ada wong", 2, 50));

        for (Person person : persons) {
            boolean flag = Predicates.and(filterName, filterAge).apply(person);

            if (flag) {
                System.out.println(person);
            }
        }
    }
}
