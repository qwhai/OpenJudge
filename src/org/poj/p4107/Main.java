package org.poj.p4107;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://bailian.openjudge.cn/practice/4107/
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int m = Integer.parseInt(reader.readLine());
            while (m-- > 0) {
                int n = Integer.parseInt(reader.readLine());
                if (n % 19 == 0) {
                    System.out.println("Yes");
                    continue;
                }
                
                String nString = String.valueOf(n);
                if (nString.contains("19")) {
                    System.out.println("Yes");
                    continue;
                }
                
                System.out.println("No");
            }
        } catch (Exception e) {
        }
    }
}
