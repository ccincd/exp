package redis;

import redis.clients.jedis.Jedis;

/**
 * First Redis Demo
 * 清空Redis数据 flushdb / flushall
 *
 * Created by cc on 16/5/5.
 */
public class HelloRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("foo", "bar");
        System.out.println(jedis.get("foo"));
    }
}
