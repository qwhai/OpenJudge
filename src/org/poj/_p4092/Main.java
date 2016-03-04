package org.poj._p4092;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            while (n-- > 0) {
                int m = Integer.parseInt(reader.readLine());
                
                // �����������
                String[] dnas = new String[m];
                for (int i = 0; i < m; i++) {
                    dnas[i] = reader.readLine();
                }
                
                // �ַ���ƥ��
                String maxSame = getMaxSameSubString(dnas);
                printSub(maxSame);
            }
        } catch (Exception e) {
        }
    }
    
    /**
     * ��ӡ�Ӵ�
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
     * ���һ���ַ����������Ӵ�
     * @param s
     * @return
     */
    private static String[] getSubString(String s) {
        int count = getSubStringCount(s);
        String[] subs = new String[count];
        // iΪ��ʼλ��,jΪ����λ��
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
     * ���һ���ַ����й��ж��ٸ��Ӵ�
     * @param s
     * @return
     */
    private static int getSubStringCount(String s) {
        return (s.length() * (s.length() + 1)) / 2;
    }
}