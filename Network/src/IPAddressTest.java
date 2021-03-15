import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressTest {

    public static void main(String[] args) {

        try {
            InetAddress inte1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inte1);

            InetAddress inte2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inte2);

            InetAddress inte3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inte3);

            System.out.println(InetAddress.getLocalHost());

            System.out.println(inte2.getHostName());
            System.out.println(inte2.getAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


}
