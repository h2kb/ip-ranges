package io.github.h2kb.model;

import java.util.InputMismatchException;
import java.util.Objects;

public class IpAddress {

    private int octet1;

    private int octet2;

    private int octet3;

    private int octet4;

    public IpAddress(String StrIpAddress) {
        String[] ipAddressInArray = StrIpAddress.split("\\.");

        try {
            this.octet1 = Integer.parseInt(ipAddressInArray[0]);
            this.octet2 = Integer.parseInt(ipAddressInArray[1]);
            this.octet3 = Integer.parseInt(ipAddressInArray[2]);
            this.octet4 = Integer.parseInt(ipAddressInArray[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InputMismatchException("You entered incorrect data");
        }
    }

    public IpAddress(int octet1, int octet2, int octet3, int octet4) {
        if (octet1 >= 0 && octet1 <= 255 &&
                octet2 >= 0 && octet2 <= 255 &&
                octet3 >= 0 && octet3 <= 255 &&
                octet4 >= 0 && octet4 <= 255) {
            this.octet1 = octet1;
            this.octet2 = octet2;
            this.octet3 = octet3;
            this.octet4 = octet4;
        } else {
            throw new InputMismatchException("You entered incorrect data");
        }
    }

    public IpAddress() {
    }

    public long ipToNumber() {
        return (long) ((octet1 * Math.pow(256, 3)) + (octet2 * Math.pow(256, 2)) + (octet3 * Math.pow(256, 1)) + (octet4 * Math.pow(256, 0)));
    }

    public IpAddress numberToIp(long num) {
        int octet1 = (int) (num / Math.pow(256, 3));
        int octet2 = (int) ((num - octet1 * Math.pow(256, 3)) / Math.pow(256, 2));
        int octet3 = (int) ((num - octet1 * Math.pow(256, 3) - octet2 * Math.pow(256, 2)) / 256);
        int octet4 = (int) (num - octet1 * Math.pow(256, 3) - octet2 * Math.pow(256, 2) - octet3 * 256);

        return new IpAddress(octet1, octet2, octet3, octet4);
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d.%d", octet1, octet2, octet3, octet4);
    }

    @Override
    public boolean equals(Object compareObject) {
        if (this == compareObject) return true;
        if (compareObject == null || getClass() != compareObject.getClass()) return false;
        IpAddress ipAddress = (IpAddress) compareObject;
        return octet1 == ipAddress.octet1 &&
                octet2 == ipAddress.octet2 &&
                octet3 == ipAddress.octet3 &&
                octet4 == ipAddress.octet4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(octet1, octet2, octet3, octet4);
    }
}
