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
}
