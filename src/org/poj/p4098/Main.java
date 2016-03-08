package org.poj.p4098;

import java.util.Scanner;

/**
 * <p>
 * http://bailian.openjudge.cn/practice/4098/
 * </p>
 * 2016年3月8日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class Main {

    public static void main(String[] args) {
        new Main().execut();
    }
    
    private void execut() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while(m-- > 0) {
            int n = scanner.nextInt();
            int[][] data = new int[n][3];
            int[] values = new int[n];
            for (int i = 0; i < data.length; i++) {
                data[i][0] = scanner.nextInt();
                data[i][1] = scanner.nextInt();
                data[i][2] = scanner.nextInt();
                
                values[i] = data[i][1] + data[i][2];
            }
            
            sortCore(values, 0, n - 1);
            
            for (int i = 0; i < data.length; i++) {
                int sum = data[i][1] + data[i][2];
                if (sum == values[n - 2]) {
                    System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + sum);
                    break;
                }
            }
        }
        
        scanner.close();
    }
    
    private void sortCore(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        
        int boundary = boundary(array, startIndex, endIndex);
        
        sortCore(array, startIndex, boundary - 1);
        sortCore(array, boundary + 1, endIndex);
    }
    
    private int boundary(int[] array, int startIndex, int endIndex) {
        int standard = array[startIndex]; // 定义标准
        int leftIndex = startIndex; // 左指针
        int rightIndex = endIndex; // 右指针
        
        while(leftIndex < rightIndex) {
            while(leftIndex < rightIndex && array[rightIndex] >= standard) {
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];
            
            while(leftIndex < rightIndex && array[leftIndex] <= standard) {
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }
        
        array[leftIndex] = standard;
        return leftIndex;
    }
}
