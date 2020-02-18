package io.github.h2kb;

import io.github.h2kb.model.IpAddress;
import io.github.h2kb.model.IpRangeGenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IpRanges {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rangeOfIpAddresses = scanner.nextLine().trim();
        String[] ipAddressesInArray = rangeOfIpAddresses.split("\\s+");
        String StrIpAddress1;
        String StrIpAddress2;

        try {
            StrIpAddress1 = ipAddressesInArray[0];
            StrIpAddress2 = ipAddressesInArray[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InputMismatchException("You entered incorrect data");
        }

        IpAddress ipAddress1 = new IpAddress(StrIpAddress1);
        IpAddress ipAddress2 = new IpAddress(StrIpAddress2);
        IpRangeGenerator ipRangeGenerator = new IpRangeGenerator();
        String ipRange = ipRangeGenerator.generate(ipAddress1, ipAddress2);

        System.out.println(ipRange);
    }
}
