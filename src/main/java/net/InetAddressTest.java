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

            InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress address : inetAddresses) {
                System.out.println(address);
            }

            InetAddress inetAddressReverse = InetAddress.getByName("180.97.33.108");
            System.out.println(inetAddressReverse.getHostName());

            InetAddress inetAddressLocal = InetAddress.getLocalHost();
            System.out.println(inetAddressLocal);

            InetAddress byAddress = InetAddress.getByAddress(new byte[] {125, 64, (byte) 232, 84});
            System.out.println(byAddress);
            System.out.println(byAddress.getHostName());

            InetAddress byAddressName = InetAddress.getByAddress("www.gamersky.com", new byte[] {125, 64, (byte) 232, 84});
            System.out.println(byAddressName);

            InetAddress wrongOne = InetAddress.getByAddress("www.wrongone.com", new byte[] {125, 64, (byte) 232, (byte) 184});
            System.out.println(wrongOne);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
