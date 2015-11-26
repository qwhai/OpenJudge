package org.poj.p2747;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                int k = Integer.parseInt(reader.readLine());
                int max = 0;
                for (int a1 = k; a1 >= 0; a1--) {
                    for (int a2 = k; a2 >= 0; a2--) {
                        for (int a3 = k; a3 >= 0; a3--) {
                            if ((a1 + a2 + a3) % 5 == 0 && (a2 + a3) % 3 == 0 && (a1 + a2) % 2 == 0) {
                                if (a1 + a2 + a3 > max) {
                                    max = a1 + a2 + a3;
                                }
                            }
                        }
                    }
                }
                
                System.out.println(max);
            }
        } catch (Exception e) {
        }
        
    }
}
