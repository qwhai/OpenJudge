package org.poj.p4111;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                String[] strings = reader.readLine().split(" ");
                String str1 = strings[0].substring(2, strings[0].length());
                String str2 = strings[1].substring(2, strings[1].length());
                
                String bytes1 = transHex(str1);
                String bytes2 = transHex(str2);
                
                int blockCount1 = calBlockCount(bytes1);
                int blockCount2 = calBlockCount(bytes2);
                
                if (blockCount1 > blockCount2) {
                    System.out.println("Alice");
                } else if (blockCount1 < blockCount2) {
                    System.out.println("Bob");
                } else {
                    System.out.println("Tie");
                }
            }
        } catch (Exception e) {
        }
    }
    
    private static int calBlockCount(String bytes) {
        String[] a = bytes.split("0");
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 0) {
                count++;
            }
        }
        return count;
    }
    
    private static String transHex(String hex) {
        String bytes = "";
        char[] hexs = hex.toCharArray();
        for (int i = 0; i < hexs.length; i++) {
            bytes += transSingleHex(hexs[i]);
        }
        return bytes;
    }
    
    private static String transSingleHex(char hex) {
        if (hex == '0') {
            return "0000";
        } else if (hex == '1') {
            return "0001";
        } else if (hex == '2') {
            return "0010";
        } else if (hex == '3') {
            return "0011";
        } else if (hex == '4') {
            return "0100";
        } else if (hex == '5') {
            return "0101";
        } else if (hex == '6') {
            return "0110";
        } else if (hex == '7') {
            return "0111";
        } else if (hex == '8') {
            return "1000";
        } else if (hex == '9') {
            return "1001";
        } else if (hex == 'a' || hex == 'A') {
            return "1010";
        } else if (hex == 'b' || hex == 'B') {
            return "1011";
        } else if (hex == 'c' || hex == 'C') {
            return "1100";
        } else if (hex == 'd' || hex == 'D') {
            return "1101";
        } else if (hex == 'e' || hex == 'E') {
            return "1110";
        } else if (hex == 'f' || hex == 'F') {
            return "1111";
        }
        
        return "";
    }
}
