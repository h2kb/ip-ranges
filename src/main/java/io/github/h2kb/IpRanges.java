package io.github.h2kb;

import io.github.h2kb.model.IpAddress;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IpRanges {

    public static void main(String[] args) {
        StringBuilder ipBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String rangeOfIpAddresses = scanner.nextLine().trim();
        String[] ipAddressesInArray = rangeOfIpAddresses.split("\\s+");
        String StrIpAddress1 = "";
        String StrIpAddress2 = "";

        try {
            StrIpAddress1 = ipAddressesInArray[0];
            StrIpAddress2 = ipAddressesInArray[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InputMismatchException("You entered incorrect data");
        }

        IpAddress ipAddress1 = new IpAddress(StrIpAddress1);
        IpAddress ipAddress2 = new IpAddress(StrIpAddress2);

        if (IpAddress.isValidRange(ipAddress1, ipAddress2)) {
            long ipToNum1 = IpAddress.ipToNumber(ipAddress1);
            long ipToNum2 = IpAddress.ipToNumber(ipAddress2);

            for (long i = ipToNum1 + 1; i < ipToNum2; i++) {
                ipBuilder.append(IpAddress.numberToIp(i)).append("\n");
            }
        } else {
            throw new InputMismatchException("You entered the wrong range");
        }

        System.out.println(ipBuilder.toString());
    }
}
