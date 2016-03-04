package org.poj.p4087;

import java.util.Scanner;

/**
 * http://bailian.openjudge.cn/practice/4087/
 */
public class Main {

    public static void main(String[] args) {
        // 数据读取
        Scanner scanner = new Scanner(System.in);
        int total, index;
        total = scanner.nextInt();
        index = scanner.nextInt();
        int[] array = new int[total];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // 数据处理
        Main main = new Main();
        main.sortCore(array, 0, array.length - 1);
        
        // 结果输出
        System.out.println(array[index - 1]);
    }
    
    /*
     * 排序的核心算法
     * 
     * @param array
     *      待排序数组
     * @param startIndex
     *      开始位置
     * @param endIndex
     *      结束位置
     */
    private void sortCore(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        
        int boundary = boundary(array, startIndex, endIndex);
        
        sortCore(array, startIndex, boundary - 1);
        sortCore(array, boundary + 1, endIndex);
    }
    
    /*
     * 交换并返回分界点
     * 
     * @param array
     *      待排序数组
     * @param startIndex
     *      开始位置
     * @param endIndex
     *      结束位置
     * @return
     *      分界点
     */
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
