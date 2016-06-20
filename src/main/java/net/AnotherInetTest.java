package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * AnotherInetTest
 *
 * Created by cc on 16/6/19.
 */
public class AnotherInetTest {

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("180.97.33.107");
            System.out.println(inetAddress.getHostName());// 需要访问DNS服务器
            System.out.println(inetAddress.getCanonicalHostName());

            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1.getHostName());// 直接返回域名
            System.out.println(inetAddress1.getCanonicalHostName());

            InetAddress inetAddress2 = InetAddress.getLocalHost();
            System.out.println(inetAddress2.getHostName());// 返回本机名
            System.out.println(inetAddress2.getCanonicalHostName());

            /*InetAddress inetAddress3 = InetAddress.getByName("cc");// UnknownHostException
            System.out.println(inetAddress3.getHostName());*/

            InetAddress inetAddress3 = InetAddress.getByName("1.2.3.4");
            System.out.println(inetAddress3.getHostName());// 返回1.2.3.4
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
