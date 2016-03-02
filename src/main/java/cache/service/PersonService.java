package cache.service;

import java.util.List;
import java.util.Random;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import toy.guava.Person;

import com.google.common.collect.Lists;

/**
 * Created by cc on 16/3/1.
 */
@Service
public class PersonService {

    private List<Person> persons = Lists.newArrayList();

    @Cacheable(value = "personCache")
    public Person getByName(String name) {
        Random random = new Random();
        int age = random.nextInt(100) + 1;
        int gentle = random.nextInt(2) + 1;

        Person newPerson = new Person(name, age, gentle);

        persons.add(newPerson);
        return newPerson;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
