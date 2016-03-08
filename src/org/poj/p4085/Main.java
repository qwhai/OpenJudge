package org.poj.p4085;

import java.util.Scanner;

/**
 * <p>
 * http://bailian.openjudge.cn/practice/4085/
 * </p>
 * 2016年3月8日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        new Main().exeute();
    }
    
    private void exeute() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] table = new int[10001];
        for (int i = 0; i < n; i++) {
            table[scanner.nextInt()] = 1;
        }
        
        boolean first = true;
        int length = table.length;
        for (int i = 0; i < length; i++) {
            if (table[i] == 1) {
                System.out.print(first ? i : " " + i);
                first = false;
            }
        }
        System.out.println();
        
        scanner.close();
    }
}
