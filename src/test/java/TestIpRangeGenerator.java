import io.github.h2kb.model.IpAddress;
import io.github.h2kb.model.IpRangeGenerator;
import org.junit.Assert;
import org.junit.Test;

public class TestIpRangeGenerator {

    IpRangeGenerator ipRangeGenerator = new IpRangeGenerator();

    @Test
    public void generate() {
        StringBuilder ipRangeBuilder = new StringBuilder();
        IpAddress ipAddress1 = new IpAddress("192.168.0.1");
        IpAddress ipAddress2 = new IpAddress("192.168.0.5");

        String ipRange = ipRangeGenerator.generate(ipAddress1, ipAddress2);
        ipRangeBuilder.append("192.168.0.2").append("\n").append("192.168.0.3").append("\n").append("192.168.0.4").append("\n");

        Assert.assertEquals(ipRange, ipRangeBuilder.toString());
    }

    @Test
    public void testIsValidInputRange() {
        IpAddress ipAddress1 = new IpAddress("192.168.0.1");
        IpAddress ipAddress2 = new IpAddress("192.168.0.5");

        IpAddress ipAddress3 = new IpAddress("192.168.0.5");
        IpAddress ipAddress4 = new IpAddress("192.168.0.1");

        Assert.assertTrue(ipRangeGenerator.isValidInputRange(ipAddress1, ipAddress2));
        Assert.assertFalse(ipRangeGenerator.isValidInputRange(ipAddress3, ipAddress4));
    }
}
