package org.poj.p4112;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://bailian.openjudge.cn/practice/4112/
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true) {
                String ciphertext = reader.readLine();
                ciphertext = ciphertext.trim();
                char[] ciphers = ciphertext.toCharArray();
                int flag = 0; // 0：不在单词内部 1：在单词内部
                int index = 0;
                String tmp = "";
                for (int i = 0; i < ciphers.length; i++) {
                    if (isLetter(ciphers[i])) {
                        if (flag == 0) {
                            index++;
                        }
                        flag = 1;
                        tmp += encode(ciphers[i], index);
                        
                        if (i == ciphers.length - 1) {
                            System.out.print(rotation(tmp));
                        }
                    } else {
                        if (flag == 1) {
                            System.out.print(rotation(tmp));
                            tmp = "";
                        }
                        flag = 0;
                        if (flag == 0) {
                            System.out.print(String.valueOf(ciphers[i]));
                        }
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
        }
    }
    
    public static String rotation(String str) {
        String rota = "";
        char[] tmps = str.toCharArray();
        for (int j = tmps.length - 1; j >= 0; j--) {
            rota += String.valueOf(tmps[j]);
        }
        
        return rota;
    }
    
    public static boolean isLetter(char c) {
        if (isLowercase(c) || isCapital(c)) {
            return true;
        }
        return false;
    }
    
    public static boolean isLowercase(char c) {
        if (('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }
    
    public static boolean isCapital(char c) {
        if (('A' <= c && c <= 'Z')) {
            return true;
        }
        return false;
    }
    
    public static char encode(char c, int index) {
        if (isLowercase(c)) {
            return (char) ('a' + (c - 'a' + 26 - index) % 26);
        }
        return (char) ('A' + (c - 'A' + 26 - index) % 26);
    }
}
