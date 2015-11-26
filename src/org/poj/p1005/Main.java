package org.poj.p1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static double PI = Math.PI;
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            int cases = 0;
            while (n-- > 0) {
                String[] tmp = reader.readLine().split(" ");
                double powDistance = distancePow(Double.parseDouble(tmp[0]), Double.parseDouble(tmp[1]));
                double S = PI * powDistance / 2;
                double yearRaw = S / 50;
                int year = (int)yearRaw + (yearRaw - (int)yearRaw > 0 ? 1 : 0);
                System.out.println("Property " + (++cases) + ": This property will begin eroding in year " + year + ".");
            }
            System.out.println("END OF OUTPUT.");
        } catch (Exception e) {
        }
    }
    
    public static double distancePow(double x, double y) {
        return (x * x + y * y);
    }
}
