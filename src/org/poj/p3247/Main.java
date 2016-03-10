package org.poj.p3247;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean odd = isOdd(n);
        int count = 0;
        StringBuffer buffer = new StringBuffer();
        if (odd) {
            n = n / 2 + 1;
            int start = (int) Math.pow(10, n) / 10;
            int end = (int) Math.pow(10, n);
            
            for (int i = start; i < end; i++) {
                int temp = (int) (i * Math.pow(10, n - 1) + reverse(i / 10));
                if (isPrime(temp)) {
                    buffer.append(count == 0 ? "" + temp : " " + temp);
                    count++;
                }
            }
        } else {
            n = n / 2;
            int start = (int) Math.pow(10, n) / 10;
            int end = (int) Math.pow(10, n);
            
            for (int i = start; i < end; i++) {
                int temp = (int) (i * Math.pow(10, n) + reverse(i));
                if (isPrime(temp)) {
                    buffer.append(count == 0 ? "" + temp : " " + temp);
                    count++;
                }
            }
        }
        
        System.out.println(count + "\n" + buffer.toString());
        scanner.close();
    }
    
    private static int reverse(int n) {
        String number = String.valueOf(n);
        StringBuffer buffer = new StringBuffer(number);
        return Integer.parseInt(buffer.reverse().toString());
    }
    
    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        int j = 0;
        double legalBoundary = Math.sqrt(n);
        for (j = 2; j < legalBoundary; j++) {
            if (n % j == 0) {
                break;
            }
        }
        
        if (j > legalBoundary) {
            return true;
        }
        
        return false;
    }
}
