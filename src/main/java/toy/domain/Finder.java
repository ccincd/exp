/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package toy.domain;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Finder
 *
 * @author cc
 * @version 1.0, 2016/10/27
 */
public class Finder {

    public static final Integer ALPHA_LEN = 26;

    public static final String CHECK_URL = "http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=";

    public static final String POSTFIX = ".com";

    public static char[] alphas = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static void queryExistence(String domain) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(CHECK_URL + domain);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            String resultStr = EntityUtils.toString(entity);
            if (resultStr.contains("210")) {
                System.out.println(domain);
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ALPHA_LEN; i++) {
            sb.append(alphas[i]);
            for (int j = 0; j < ALPHA_LEN; j++) {
                sb.append(alphas[j]);
                String domain = sb.toString() + POSTFIX;
                queryExistence(domain);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
