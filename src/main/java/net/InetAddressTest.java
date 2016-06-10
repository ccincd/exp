package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddressTest
 *
 * Created by cc on 16/6/10.
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.gamersky.com");
            System.out.println(inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
