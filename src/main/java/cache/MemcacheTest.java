package cache;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * MemcacheTest
 *
 * @author chi.chen
 * @date 16-2-15
 * @time 上午11:30
 */
public class MemcacheTest {

    public static void main(String[] args) {
        MemcachedClientBuilder cacheBuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"),
                new int[] { 1 });

        MemcachedClient cacheClient = null;

        try {
            cacheClient = cacheBuilder.build();

            cacheClient.set("hello", 0, "hi, there");
            System.out.println("hello=" + cacheClient.get("hello"));
            cacheClient.delete("hello");
            System.out.println("hello=" + cacheClient.get("hello"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } finally {
            if (cacheClient != null) {
                try {
                    cacheClient.shutdown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
