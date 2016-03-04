package org.poj.p4088;

import java.util.Scanner;

/**
 * http://bailian.openjudge.cn/practice/4088/
 * (A - B) ∪ (B - A)
 */
public class Main {

    public static void main(String[] args) {
        byte[] table = new byte[1 << 30];
        
        // 数据采集
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            table[data] = 1;
        }
        
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int data = scanner.nextInt();
            if (table[data] == 0) {
                table[data] = 2;
            } else if (table[data] == 1) {
                table[data] = -1;
            }
        }
        
        // 筛选及打印
        int length = table.length;
        boolean isFirst = true;
        for (int i = 0; i < length; i++) {
            if (table[i] == 1 || table[i] == 2) {
                if (isFirst) {
                    System.out.print(i);
                    isFirst = false;
                } else {
                    System.out.print(" " + i);
                }
            }
        }
        System.out.println();
        
        scanner.close();
    }
}