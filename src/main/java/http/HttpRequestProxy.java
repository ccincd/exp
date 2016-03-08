package http;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

/**
 * HttpRequestProxy
 *
 * @author chi.chen
 * @date 16-3-8
 * @time 上午10:24
 */
public class HttpRequestProxy {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestProxy.class);

    private static final Joiner.MapJoiner COOKIE_JOINER = Joiner.on(";").withKeyValueSeparator("=");

    /**
     * 表示请求方法的Enum
     */
    private RequestMethod requestMethod;

    /**
     * 协议,主机名和端口
     */
    private String requestURL;

    /**
     * /xx/xxx
     */
    private String requestURI;

    /**
     * 请求ContentType
     */
    private String contentType;

    /**
     * 请求参数
     */
    private Map<String, List<String>> requestParams = Maps.newLinkedHashMap();

    /**
     * Cookie
     */
    private Map<String, String> cookies = Maps.newLinkedHashMap();

    /**
     * requestBody中的请求参数
     */
    private String requestBody;
}
