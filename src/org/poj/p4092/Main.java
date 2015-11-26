package org.poj.p4092;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                int m = Integer.parseInt(reader.readLine());
                
                // 获得输入数据
                String[] dnas = new String[m];
                for (int i = 0; i < m; i++) {
                    dnas[i] = reader.readLine();
                }
                
                // 字符串匹配
                String maxSame = getMaxSameSubString(dnas);
                printSub(maxSame);
            }
        } catch (Exception e) {
        }
    }
    
    /**
     * 打印子串
     * @param sub
     */
    private static void printSub(String sub) {
        if (sub.length() < 3) {
            System.out.println("no significant commonalities");
        } else {
            System.out.println(sub);
        }
    }
    
    private static String getMaxSameSubString(String[] dnas) {
        String[] subsofDNAFirst = getSubString(dnas[0]);
        sortByLength(subsofDNAFirst);
        
        int[] subFlag = new int[subsofDNAFirst.length];
        String maxSubDNA = "";
        for (int i = 0; i < subsofDNAFirst.length; i++) {
            boolean allSub = true;
            for (int j = 1; j < dnas.length; j++) {
                if (!dnas[j].contains(subsofDNAFirst[i])) {
                    allSub = false;
                    break;
                }
            }
            
            if (allSub) {
                subFlag[i] = 1;
                maxSubDNA = subsofDNAFirst[i];
                break;
            }
        }
        
        return maxSubDNA;
    }
    
    private static void sortByLength(String[] subdnas) {
        for (int i = 0; i < subdnas.length; i++) {
            for (int j = i + 1; j < subdnas.length; j++) {
                if (subdnas[i].length() < subdnas[j].length()) {
                    String tmpString = subdnas[i];
                    subdnas[i] = subdnas[j];
                    subdnas[j] = tmpString;
                }
            }
        }
    }
    
    /**
     * 获得一个字符串的所有子串
     * @param s
     * @return
     */
    private static String[] getSubString(String s) {
        int count = getSubStringCount(s);
        String[] subs = new String[count];
        // i为开始位置,j为结束位置
        for (int i = 0, ct = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] sub = new char[j - i];
                for (int k = i; k < j; k++) {
                    sub[k - i] = s.charAt(k);
                }
                subs[ct++] = String.valueOf(sub);
            }
        }
        
        return subs;
    }
    
    /**
     * 获得一个字符串中共有多少个子串
     * @param s
     * @return
     */
    private static int getSubStringCount(String s) {
        return (s.length() * (s.length() + 1)) / 2;
    }
}