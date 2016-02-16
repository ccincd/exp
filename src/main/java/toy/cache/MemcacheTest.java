package toy.cache;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.CASOperation;
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

    /**
     * {@link TestEnum}
     */
    private int welcome;

    public static void main(String[] args) {
        MemcachedClientBuilder cacheBuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"),
                new int[] { 1 });

        MemcachedClient cacheClient = null;

        try {
            cacheClient = cacheBuilder.build();

            cacheClient.set("hello", 0, "hi, there");
            System.out.println(cacheClient.set("hello", 0, "set"));
            System.out.println(cacheClient.add("hello", 0, "add"));
            System.out.println("hello=" + cacheClient.get("hello"));

            /*
             * GetsResponse<String> response = cacheClient.gets("hello"); long cas = response.getCas();
             */
            /**
             * Cas is a check and set operation which means "store this data but only if no one else has updated since I
             * last fetched it."
             */
            /*
             * if (!cacheClient.cas("hello", 0, "Happy!", cas)) { System.out.println("cas error"); }
             */
            cacheClient.cas("hello", 0, new CASOperation<String>() {
                @Override
                public int getMaxTries() {
                    return Integer.MAX_VALUE;
                }

                @Override
                public String getNewValue(long currentCAS, String currentValue) {
                    return "Happy!";
                }
            });

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

    /**
     * @see #hi()
     *
     * @param str
     */
    public void hi(String str) {
        System.out.println(str);
    }

    public void hi() {
        System.out.println("hi");
    }

    public int getWelcome() {
        return welcome;
    }

    public void setWelcome(int welcome) {
        this.welcome = welcome;
    }
}
