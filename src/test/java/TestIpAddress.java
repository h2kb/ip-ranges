import io.github.h2kb.model.IpAddress;
import org.junit.Assert;
import org.junit.Test;

public class TestIpAddress {

    @Test
    public void testIpToNumber() {
        IpAddress ipAddress1 = new IpAddress("77.88.21.8");
        IpAddress ipAddress2 = new IpAddress("192.168.1.100");
        IpAddress ipAddress3 = new IpAddress("172.16.5.25");
        IpAddress ipAddress4 = new IpAddress("0.0.0.0");
        IpAddress ipAddress5 = new IpAddress("195.206.40.177");
        IpAddress ipAddress6 = new IpAddress("10.10.0.1");

        long ipAsNum1 = ipAddress1.ipToNumber();
        long ipAsNum2 = ipAddress2.ipToNumber();
        long ipAsNum3 = ipAddress3.ipToNumber();
        long ipAsNum4 = ipAddress4.ipToNumber();
        long ipAsNum5 = ipAddress5.ipToNumber();
        long ipAsNum6 = ipAddress6.ipToNumber();

        Assert.assertEquals(1297618184L, ipAsNum1);
        Assert.assertEquals(3232235876L, ipAsNum2);
        Assert.assertEquals(2886731033L, ipAsNum3);
        Assert.assertEquals(0L, ipAsNum4);
        Assert.assertEquals(3285067953L, ipAsNum5);
        Assert.assertEquals(168427521L, ipAsNum6);
    }

    @Test
    public void testNumberToIp() {
        long ipAsNum1 = 1297618184L;
        long ipAsNum2 = 1297618184L;

        long ipAsNum3 = 3285067953L;
        long ipAsNum4 = 1297618184L;

        IpAddress ipAddress1 = new IpAddress().numberToIp(ipAsNum1);
        IpAddress ipAddress2 = new IpAddress().numberToIp(ipAsNum2);

        IpAddress ipAddress3 = new IpAddress().numberToIp(ipAsNum3);
        IpAddress ipAddress4 = new IpAddress().numberToIp(ipAsNum4);

        Assert.assertEquals(ipAddress1, ipAddress2);
        Assert.assertNotEquals(ipAddress3, ipAddress4);
    }
}
