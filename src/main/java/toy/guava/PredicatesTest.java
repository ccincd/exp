package toy.guava;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Predicate;

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
            return false;
        }
    };

    public static void main(String[] args) {
        //
    }
}
