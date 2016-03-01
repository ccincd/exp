package cache;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * Memcached
 *
 * @author chi.chen
 * @date 16-3-1
 * @time 下午12:03
 */
public class Memcached implements InitializingBean, DisposableBean {

    private final static Logger logger = LoggerFactory.getLogger(Memcached.class);

    private MemcachedClient memcachedClient;

    private MemcachedClient buildMemcachedClient(String addr) {
        MemcachedClientBuilder clientBuilder = new XMemcachedClientBuilder(AddrUtil.getAddresses(addr));

        clientBuilder.setFailureMode(false);
        clientBuilder.setConnectionPoolSize(3);
        clientBuilder.setSessionLocator(new KetamaMemcachedSessionLocator());

        try {
            MemcachedClient client = clientBuilder.build();
            client.setSanitizeKeys(true);
            int compressionLimitBytes = 1024;
            client.getTranscoder().setCompressionThreshold(compressionLimitBytes);

            return client;
        } catch (IOException e) {
            logger.error("memcache初始化失败，addr={}", addr, e);
        }

        return null;
    }

    public MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }

    public void setMemcachedClient(String addr) {
        this.memcachedClient = buildMemcachedClient(addr);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(memcachedClient, "memcachedClient不能为空！");
    }

    @Override
    public void destroy() throws Exception {
        this.memcachedClient.shutdown();
    }
}
