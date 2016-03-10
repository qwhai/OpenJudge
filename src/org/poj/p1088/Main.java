package org.poj.p1088;

import java.util.Scanner;

/**
 * <p>
 * 1088:滑雪
 * http://bailian.openjudge.cn/practice/1088/
 * </p>
 * Create Date: 2016年3月10日
 * Last Modify: 2016年3月10日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    private static int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int C = scanner.nextInt();
            int R = scanner.nextInt();
            
            int[][] map = new int[C][R];
            int[][] table = new int[C][R];
            boolean[][] sure = new boolean[C][R];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = scanner.nextInt();
                    table[i][j] = 1;
                }
            }
            
            scanner.close();
            
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    check(map, table, sure, i, j);
                    sure[i][j] = true;
                }
            }
            
            // print
            int maxL = 0;
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (maxL < table[i][j]) {
                        maxL = table[i][j];
                    }
                }
            }
            
            System.out.println(maxL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void check(int[][] map, int[][] table, boolean[][] sure, int i, int j) {
        if (sure[i][j]) {
            return;
        }
        
        // 从各个方向上进行遍历
        for (int k = 0; k < dir.length; k++) {
            int nc = i + dir[k][0]; // 新坐标的行
            int nr = j + dir[k][1]; // 新坐标的列
            // 边界检测
            if (nc < 0 || nc >= map.length || nr < 0 || nr >= map[nc].length) {
                continue;
            }
            if (map[i][j] > map[nc][nr]) {
                check(map, table, sure, nc, nr);
                table[i][j] = Math.max(table[i][j], table[nc][nr] + 1);
            } else {
                table[i][j] = Math.max(table[i][j], 1);
            }
        }
    }
}
