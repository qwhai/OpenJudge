package org.poj.p4106;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                String label = reader.readLine();
                char[] letters = label.toCharArray();
                int[] times = new int[62];
                String flag = "";
                for (int i = 0; i < letters.length; i++) {
                    if (!flag.contains(letters[i] + "")) {
                        flag += letters[i];
                    }
                    
                    times[index(letters[i])]++;
                }
                
                printResult(times, flag);
            }
        } catch (Exception e) {
        }
    }
    
    private static void printResult(int[] times, String flag) {
        for (int i = 0; i < flag.length(); i++) {
            if (times[index(flag.charAt(i))] == 2) {
                System.out.println(flag.charAt(i));
                return;
            }
        }
    }
    
    private static int index(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        
        if ('a' <= c && c <= 'z') {
            return c - 'a' + 10;
        }
        
        if ('A' <= c && c <= 'Z') {
            return c - 'A' + 36;
        }
        
        return -1;
    }
}
