package test;

import javax.annotation.Resource;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import toy.guava.Person;
import cache.Memcached;
import cache.service.PersonService;

import common.BaseTest;

/**
 * Created by cc on 16/3/1.
 */
public class MemcachedTest extends BaseTest {

    private static final int ITERATION_NUM = 10000;

    @Resource
    Memcached memcached;

    @Resource
    PersonService personService;

    @Test
    public void testMemcached() {
        MemcachedClient memcachedClient = memcached.getMemcachedClient();
    }

    @Test
    public void testSimpleCacheAnnotation() {
        for (int i = 0; i < ITERATION_NUM; i++) {
            String name = RandomStringUtils.randomAlphabetic(3);

            Person person = personService.getByName(name);
            Assert.assertNotNull(person);
        }

        System.out.println(personService.getPersons().size());
    }
}
