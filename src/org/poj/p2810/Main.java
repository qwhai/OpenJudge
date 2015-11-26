package org.poj.p2810;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= n; i++) {
                profect(i, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void profect(int a, int n) {
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    if (a * a * a == i * i * i + j * j * j + k * k * k) {
                        System.out.println("Cube = " + a + ", Triple = (" + i + "," + j + "," + k + ")");
                    }
                }
            }
        }
    }
}
