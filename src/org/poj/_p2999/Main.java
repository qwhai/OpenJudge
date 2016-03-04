package org.poj._p2999;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://bailian.openjudge.cn/practice/2999
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            @SuppressWarnings("unused")
            int m1 = Integer.parseInt(reader.readLine());
            String[] numberStrings1 = reader.readLine().split(" ");
            @SuppressWarnings("unused")
            int m2 = Integer.parseInt(reader.readLine());
            String[] numberStrings2 = reader.readLine().split(" ");
            int[] nums1 = new int[numberStrings1.length];
            int[] nums2 = new int[numberStrings2.length];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = Integer.parseInt(numberStrings1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = Integer.parseInt(numberStrings2[i]);
            }
            
            int[] ascNums = maxAscLength(nums1, nums2);
            
            System.out.println(ascNums.length);
            for (int i = 0; i < ascNums.length; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(ascNums[i]);
            }
        } catch (Exception e) {
        }
        
    }
    
    public static int[] maxAscLength(int[] nums1, int[] nums2) {
        if (nums1.length == 1) {
            return nums1;
        }
        
        int maxLen = 0;
        int[] subMax = new int[nums1.length];
        int[] path = new int[nums1.length]; // ��¼�����д�λ������Ӧ����һ������Index
        for (int i = 0; i < subMax.length; i++) {
            subMax[i] = 1;
        }
        for (int i = 0; i < path.length; i++) {
            path[i] = i;
        }
        
        int index = 0; // ���ڼ�¼������nums1�е�������������һ�������±�
        int index2 = 0; // ���ڼ�¼��
        for (int i = 1; i < nums1.length; i++) {
            while (index2 < nums2.length) {
                if (nums1[i] == nums2[index2]) {
                    break;
                }
                index2++;
            }
            
            int max = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (subMax[j] > max && nums1[i] > nums1[j]) {
                    max = subMax[j];
                    path[i] = j;
                }
            }
            subMax[i] = max + 1;
            if (subMax[i] > maxLen) {
                maxLen = subMax[i];
                index = i;
            }
        }
        
        // ���㲢��ӡ·��
        int[] descNums = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            descNums[i] = nums1[index];
            index = path[index];
        }
        
        int[] ascNums = new int[descNums.length];
        for (int i = descNums.length - 1, j = 0; i >= 0; i--) {
            ascNums[j++] = descNums[i];
        }
        
        return ascNums;
    }
}
