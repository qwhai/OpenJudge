package org.poj.p4095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                String name = reader.readLine();
                boolean lastFlag = true; // 前一个字母为小写字母
                int clickCount = 0;
                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    if (isCapital(c) && lastFlag) {
                        clickCount += 2;
                        lastFlag = false;
                    } else if (isCapital(c) && !lastFlag) {
                        clickCount += 1;
                        lastFlag = false;
                    } else if (!isCapital(c) && lastFlag) {
                        clickCount += 1;
                        lastFlag = true;
                    } else if (!isCapital(c) && !lastFlag) {
                        clickCount += 2;
                        lastFlag = true;
                    }
                }
                
                System.out.println(clickCount);
            }
        } catch (Exception e) {
        }
    }
    
    /**
     * 是否为大写字母
     */
    private static boolean isCapital(char c) {
        if ('A' <= c && c <= 'Z') {
            return true;
        }
        
        return false;
    }
}
