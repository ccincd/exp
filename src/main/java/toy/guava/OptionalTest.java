package toy.guava;

import com.google.common.base.Optional;

/**
 * OptionalTest
 *
 * @author chi.chen
 * @date 16-3-1
 * @time 下午2:09
 */
public class OptionalTest {

    public static void main(String[] args) {
        Person captain = new Person("captain", 1, 46);
        Person jack = new Person("jack", 1, 32);
        Person rose = null;

        Optional<Person> cap = Optional.of(captain);
        Optional<Person> male = Optional.fromNullable(jack);
        Optional<Person> female = Optional.fromNullable(rose);
        Optional<Person> nobody = Optional.absent();

        if (male.isPresent()) {
            System.out.println("jack is here!");
        }

        if (!female.isPresent()) {
            System.out.println("rose is not here!");
        }

        nobody.or(captain).sayHello();
        nobody.or(cap).get().sayHello();
    }
}
