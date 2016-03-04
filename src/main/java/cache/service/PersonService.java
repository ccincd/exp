package cache.service;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cache.bean.Person;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

/**
 * Created by cc on 16/3/1.
 */
@Service
public class PersonService {

    Map<String, Person> persons = Maps.newHashMap();

    @Cacheable(value = "personCache")
    public Optional<Person> getByName(String name) {
        Preconditions.checkNotNull(name, "name can not be null");

        if (persons.containsKey(name)) {
            System.out.println("get a person from a fake db");
            return Optional.of(persons.get(name));
        }

        System.out.println("no person specified in the fake db");
        return Optional.absent();
    }

    public void addPerson(Person person) {
        Preconditions.checkNotNull(person, "person should not be null");
        Preconditions.checkNotNull(person.getName(), "name can not be null");

        persons.put(person.getName(), person);
    }

    public void addPerson(List<Person> persons) {
        Preconditions.checkNotNull(persons, "person list is null");

        for (Person person : persons) {
            addPerson(person);
        }
    }

    public int getPersonNumber() {
        return persons.size();
    }

    @CacheEvict(value = "personCache", key = "#person.getName()")
    public void updateAge(Person person) {
        Preconditions.checkNotNull(person, "person should not be null");
        Preconditions.checkNotNull(person.getName(), "name can not be null");

        if (persons.containsKey(person.getName())) {
            System.out.println("update a person by name in a fake db");
            persons.put(person.getName(), person);
        } else {
            System.out.println("no specified person, update failed");
        }
    }
}
