package cache.factory;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import cache.bean.Person;
import cache.common.Constants;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Created by cc on 16/3/4.
 */
public class PersonFactory {

    public static Random random = new Random();

    public static Person newRandomPerson() {
        return new Person(
                getRandomName(),
                getRandomAge(),
                getRandomGentle()
        );
    }

    public static Person newPersonWithRandomAgeAndGentle(String name) {
        Preconditions.checkNotNull(name, "name can not be null");

        return new Person(
                name,
                getRandomAge(),
                getRandomGentle()
        );
    }

    public static List<Person> newSomeRandomPerson(int num) {
        Preconditions.checkArgument(num > 0 && num <= Constants.MAX_RANDOM_PERSON_NUM, "illegal argument");

        List<Person> persons = Lists.newArrayListWithCapacity(num);
        for (int i = 0; i < num; i++) {
            persons.add(newRandomPerson());
        }

        return persons;
    }

    private static String getRandomName() {
        return RandomStringUtils.randomAlphabetic(Constants.NAME_LENGTH);
    }

    private static int getRandomAge() {
        return random.nextInt(100) + 1;
    }

    private static int getRandomGentle() {
        return random.nextInt(2) + 1;
    }
}
