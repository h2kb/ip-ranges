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

        long ipAsNum1 = IpAddress.ipToNumber(ipAddress1);
        long ipAsNum2 = IpAddress.ipToNumber(ipAddress2);
        long ipAsNum3 = IpAddress.ipToNumber(ipAddress3);
        long ipAsNum4 = IpAddress.ipToNumber(ipAddress4);
        long ipAsNum5 = IpAddress.ipToNumber(ipAddress5);

        Assert.assertEquals(1297618184L, ipAsNum1);
        Assert.assertEquals(3232235876L, ipAsNum2);
        Assert.assertEquals(2886731033L, ipAsNum3);
        Assert.assertEquals(0L, ipAsNum4);
        Assert.assertEquals(3285067953L, ipAsNum5);
    }

    @Test
    public void testNumberToIp() {
        long ipAsNum1 = 1297618184L;
        long ipAsNum2 = 1297618184L;

        long ipAsNum3 = 3285067953L;
        long ipAsNum4 = 1297618184L;

        IpAddress ipAddress1 = IpAddress.numberToIp(ipAsNum1);
        IpAddress ipAddress2 = IpAddress.numberToIp(ipAsNum2);

        IpAddress ipAddress3 = IpAddress.numberToIp(ipAsNum3);
        IpAddress ipAddress4 = IpAddress.numberToIp(ipAsNum4);

        Assert.assertEquals(ipAddress1, ipAddress2);
        Assert.assertNotEquals(ipAddress3, ipAddress4);
    }

    @Test
    public void testGenerateIpRange() {
        StringBuilder ipRangeBuilder = new StringBuilder();
        IpAddress ipAddress1 = new IpAddress("192.168.0.1");
        IpAddress ipAddress2 = new IpAddress("192.168.0.5");

        String ipRange = IpAddress.generateIpRange(ipAddress1, ipAddress2);
        ipRangeBuilder.append("192.168.0.2").append("\n").append("192.168.0.3").append("\n").append("192.168.0.4").append("\n");

        Assert.assertEquals(ipRange, ipRangeBuilder.toString());
    }

    @Test
    public void testIsValidInputRange() {
        IpAddress ipAddress1 = new IpAddress("192.168.0.1");
        IpAddress ipAddress2 = new IpAddress("192.168.0.5");

        IpAddress ipAddress3 = new IpAddress("192.168.0.5");
        IpAddress ipAddress4 = new IpAddress("192.168.0.1");

        Assert.assertTrue(IpAddress.isValidInputRange(ipAddress1, ipAddress2));
        Assert.assertFalse(IpAddress.isValidInputRange(ipAddress3, ipAddress4));
    }
}
