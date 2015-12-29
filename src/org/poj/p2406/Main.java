package org.poj.p2406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p>
 * Time Limit Exceeded
 * </p>
 * 2015年12月24日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String label = "";
        try {
            while (!(label = reader.readLine()).equals(".")) {
                System.out.println(minCycle(label));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 计算最小正周期
    private static int minCycle(String label) {
        int cycle = 1;
        int length = label.length();
        ArrayList<Integer> factors = factors(length);
        if (factors == null) {
            return 1;
        }
        
        int factorSize = factors.size();
        for (int i = 0; i < factorSize; i++) {
            String pattern = label.substring(0, factors.get(i));
            if (splicing(label, pattern)) {
                cycle = length / factors.get(i);
                break;
            }
        }
        
        return cycle;
    }
    
    // 统计一个数的所有因子
    private static ArrayList<Integer> factors(int n) {
        if (n <= 0) {
            return null;
        }
        
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        
        return factors;
    }
    
    // 判断一个字符串是可以由另一个字符串经过N次拼接得到
    private static boolean splicing(String label, String pattern) {
        label = label.replaceAll(pattern, "");
        return label.length() == 0;
    }
}
