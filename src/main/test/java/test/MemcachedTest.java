package test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import cache.bean.Person;
import cache.common.Constants;
import cache.factory.PersonFactory;
import cache.service.PersonService;

import com.google.common.base.Optional;
import common.BaseTest;

/**
 * Created by cc on 16/3/1.
 */
public class MemcachedTest extends BaseTest {

    /*@Resource
    Memcached memcached;*/

    private static String[] names = new String[] {
        "Leonard",
        "Jackson",
        "Rose",
        "Claire"
    };
    @Resource
    PersonService personService;

    @Test
    public void testSimpleCacheAnnotation() {
        List<Person> persons = PersonFactory.newSomeRandomPerson(Constants.MAX_RANDOM_PERSON_NUM);
        personService.addPerson(persons);

        System.out.println(personService.getPersonNumber() + ":" + Constants.MAX_RANDOM_PERSON_NUM);

        for (String name : names) {
            Person person = PersonFactory.newPersonWithRandomAgeAndGentle(name);
            personService.addPerson(person);
        }

        Optional<Person> dbPerson = personService.getByName(names[0]);// from fake db
        Optional<Person> cachePerson = personService.getByName(names[0]);// from cache

        Assert.assertTrue(dbPerson.isPresent());
        Assert.assertTrue(cachePerson.isPresent());

        cachePerson.get().setAge(28);
        personService.updateAge(cachePerson.get());// evict from cache

        dbPerson = personService.getByName(names[0]);

        System.out.println(dbPerson.get());

        System.out.println("####################");

        personService.getByName(names[2]);// from fake db
        personService.getByName(names[2]);// from fake db

        System.out.println("********************");

        Optional<Person> leonard = personService.getByName(names[1]);// from fake db
        personService.getByNameAndAge(leonard.get().getName(), leonard.get().getAge());// from fake db
        personService.getByNameAndAge(leonard.get().getName(), leonard.get().getAge());// from cache
        Optional<Person> absent = personService.getByNameAndAge(leonard.get().getName(), 105);// no such person
        Assert.assertTrue(!absent.isPresent());

        System.out.println(".....................");
        Person p1 = personService.updatePerson(leonard.get());
        Person p2 = personService.updatePerson(leonard.get());

        System.out.println(p1);
        System.out.println(p2);
    }
}
