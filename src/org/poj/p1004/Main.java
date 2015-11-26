package org.poj.p1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        double[] closingBalances = new double[12];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            double sum = 0.0;
            for (int i = 0; i < closingBalances.length; i++) {
                closingBalances[i] = Double.parseDouble(reader.readLine());
                sum += closingBalances[i];
            }
            
            double ave = sum / 12;
            System.out.println("$" + (((int)(ave * 100))/100.0));
        } catch (Exception e) {
        }
    }
}