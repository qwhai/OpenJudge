package org.poj.p4094;

import java.util.Scanner;

/**
 * <p>
 * http://bailian.openjudge.cn/practice/4094/
 * </p>
 * 2016年3月4日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        // 数据的录入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[][] infos = new int[n][2];
        for (int i = 0; i < infos.length; i++) {
            infos[i][0] = scanner.nextInt();
            infos[i][1] = scanner.nextInt();
        }
        scanner.close();
        
        // 数据处理
        int[] lastSeconds = new int[n];
        for (int i = 0; i < infos.length; i++) {
            lastSeconds[i] = infos[i][0] + s / infos[i][1];
        }
        
        // 结果输出
        int maxSecond = Integer.MIN_VALUE;
        for (int i = 0; i < lastSeconds.length; i++) {
            if (lastSeconds[i] > maxSecond) {
                maxSecond = lastSeconds[i];
            }
        }
        System.out.println(maxSecond);
    }
}
