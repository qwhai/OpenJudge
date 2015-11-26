package org.poj.p2105;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                String binaryIP = reader.readLine();
                String ipPart1 = binaryIP.substring(0, 8);
                String ipPart2 = binaryIP.substring(8, 16);
                String ipPart3 = binaryIP.substring(16, 24);
                String ipPart4 = binaryIP.substring(24, 32);
                int ip1 = binary2Decimal(ipPart1);
                int ip2 = binary2Decimal(ipPart2);
                int ip3 = binary2Decimal(ipPart3);
                int ip4 = binary2Decimal(ipPart4);
                
                System.out.println(ip1 + "." + ip2 + "." + ip3 + "." + ip4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static int binary2Decimal(String binaryString) {
        return binary2Decimal(binaryString.toCharArray());
    }
    
    private static int binary2Decimal(char[] bytes) {
        int dec = 0;
        for (int i = bytes.length - 1; i >= 0; i--) {
            dec += (Integer.parseInt(bytes[i] + "") * (Math.pow(2, 8 - i - 1)));
        }
        
        return dec;
    }
}
