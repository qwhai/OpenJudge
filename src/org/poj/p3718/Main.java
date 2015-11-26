package org.poj.p3718;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                String str1 = Integer.toBinaryString(a);
                String str2 = Integer.toBinaryString(b);
                for (int j = 0; j < 16 - str1.length(); j++) {
                    str1 = "0" + str1;
                }
                for (int j = 0; j < 16 - str2.length(); j++) {
                    str2 = "0" + str2;
                }
                str1 = str1 + str1;
                if (str1.contains(str2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        
        scanner.close();
    }
}