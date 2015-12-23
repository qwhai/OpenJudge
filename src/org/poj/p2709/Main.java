package org.poj.p2709;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static double getFactorial(int n) {
        double f = 1;
        for (int i = 0; i < n; i++) {
            f *= (i + 1);
        }
        
        return f;
    }
    
    private static double getSubFactorial(int n) {
        return (1 / getFactorial(n));
    }
    
    private static double getSumFactorial(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += getSubFactorial(i + 1);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double result = getSumFactorial(n) + 1;
        DecimalFormat df = new DecimalFormat("0.0000000000");
        System.out.println(df.format(result) + "");
        input.close();
    }
}