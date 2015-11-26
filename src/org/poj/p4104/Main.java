package org.poj.p4104;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://bailian.openjudge.cn/practice/4104/
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String segments = reader.readLine();
            char[] cs = segments.toCharArray();
            
            int flag = 0; // 0：不在单词内部 1：在单词内部
            String tmp = "";
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] != ' ') { // isLetter(cs[i])
                    flag = 1;
                    tmp += cs[i];
                    if (i == cs.length - 1) {
                        System.out.print(rotation(tmp));
                    }
                } else {
                    if (flag == 1) {
                        System.out.print(rotation(tmp) + cs[i]);
                        tmp = "";
                    } else {
                        System.out.print(cs[i] + "");
                    }
                    flag = 0;
                }
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
}