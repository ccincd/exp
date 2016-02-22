package toy.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

/**
 * HttpProxy
 *
 * @author chi.chen
 * @date 16-2-22
 * @time 下午3:28
 */
public class HttpProxy {

    private static final Logger logger = LoggerFactory.getLogger(HttpProxy.class);

    private static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

    private RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        HttpProxy httpProxy = new HttpProxy();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hi", "there");
        params.put("hello", "glad");
        params.put("name", "陈驰");

        String str = httpProxy.concatParams(params, true);
        System.out.println(str);
    }

    public Map<String, Object> getRequestParameters(HttpServletRequest request) {
        Map<String, Object> map = Maps.newHashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                // 有这种情况：url?key1=value1&key1=value2，这里忽略这种特殊情况
                map.put(paramName, paramValues[0]);
            }
        }

        return map;
    }

    public Map<String, Object> doPost(String url, Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", JSON_CONTENT_TYPE);
        HttpEntity<?> entity = new HttpEntity<Map>(params, headers);
        Map response = restTemplate.postForObject(url, entity, Map.class);

        return response;
    }

    public Map<String, Object> doGet(String url, Map<String, Object> params) {
        if (MapUtils.isNotEmpty(params)) {
            url = url + "?" + concatParams(params, false);
        }

        Map response = restTemplate.getForObject(url, Map.class);

        return response;
    }

    private String concatParams(Map<String, Object> params, boolean isUtf8Encoding) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String key : params.keySet()) {
            Object value = params.get(key);
            if (isUtf8Encoding) {
                try {
                    value = URLEncoder.encode(value.toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    logger.error("对参数进行utf8编码失败，params={}", params);
                    throw new RuntimeException("对参数进行utf8编码失败！");
                }
            }

            stringBuilder.append(key).append("=").append(value).append("&");
        }

        if (MapUtils.isNotEmpty(params)) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }
}
