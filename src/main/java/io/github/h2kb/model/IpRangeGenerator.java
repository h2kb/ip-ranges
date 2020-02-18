package io.github.h2kb.model;

import java.util.InputMismatchException;

public class IpRangeGenerator {

    public boolean isValidInputRange(IpAddress ipAddress1, IpAddress ipAddress2) {
        long ipAsNum1 = ipAddress1.ipToNumber();
        long ipAsNum2 = ipAddress2.ipToNumber();

        return ipAsNum1 <= ipAsNum2;
    }

    public String generate(IpAddress ipAddress1, IpAddress ipAddress2) {
        StringBuilder ipRangeBuilder = new StringBuilder();

        if (isValidInputRange(ipAddress1, ipAddress2)) {
            long ipAsNum1 = ipAddress1.ipToNumber();
            long ipAsNum2 = ipAddress2.ipToNumber();

            for (long i = ipAsNum1 + 1; i < ipAsNum2; i++) {
                ipRangeBuilder.append(new IpAddress().numberToIp(i)).append("\n");
            }
        } else {
            throw new InputMismatchException("You entered the wrong range");
        }

        return ipRangeBuilder.toString();
    }
}
