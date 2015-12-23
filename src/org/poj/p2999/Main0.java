package org.poj.p2999;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * http://bailian.openjudge.cn/practice/2999
 */
public class Main0 {

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
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        list.add(nums1[i]);
                    }
                }
            }
            
            int[] nums = new int[list.size()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = list.get(i);
            }
            
            maxAscLength(nums);
        } catch (Exception e) {
        }
        
    }
    
    public static int maxAscLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int maxLen = 0;
        int[] subMax = new int[nums.length];
        int[] path = new int[nums.length];
        for (int i = 0; i < subMax.length; i++) {
            subMax[i] = 1;
        }
        
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (subMax[j] > max && nums[i] > nums[j]) {
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
        
        System.out.println(maxLen);
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < maxLen; i++) {
            buffer.append(nums[index] + " ");
            index = path[index];
        }
        
        System.out.println(buffer.reverse().toString().trim());
        
        return maxLen;
    }
}
