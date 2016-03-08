package org.poj.p4101;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * http://bailian.openjudge.cn/practice/4101/
 * </p>
 * 2016年3月8日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        try {
            new Main().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void execute() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        while(k-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            char[][] table = new char[n][n];
            for (int i = 0; i < n; i++) {
                table[i] = reader.readLine().toCharArray();
            }
            
            int[][] flag = new int[n][n];
            search(table, flag);

            int countB = 0;
            int countR = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int index = i * n + j + 1;
                    if (flag[i][j] == index) {
                        if (table[i][j] == 'r') {
                            countR++;
                        } else if (table[i][j] == 'b') {
                            countB++;
                        }
                    }
                }
            }
            
            System.out.println(countR + " " + countB);
        }
    }
    
    private void search(char[][] table, int[][] flag) {
        int length = flag.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int index = i * length + j + 1;
                if (table[i][j] == 'b') {
                    flag[i][j] = index;
                } else if (table[i][j] == 'r') {
                    flag[i][j] = index;
                } else {
                    flag[i][j] = -1;
                    continue;
                }
                
                // check
                check(table, flag, i, j);
            }
        }
    }
    
    private void check(char[][] table, int[][] flag, int x, int y) {
        if (x - 1 >= 0 && table[x][y] == table[x - 1][y]) {
            flag[x][y] = flag[x - 1][y];
            return;
        }
        
        if (y - 1 >= 0 && table[x][y] == table[x][y - 1]) {
            flag[x][y] = flag[x][y - 1];
            return;
        }
    }
}
