package org.poj.p2757;

/**
 * http://bailian.openjudge.cn/practice/2757/
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int[] nums = reader();
        int maxLength = maxAscLength(nums);
        System.out.println(maxLength);
    }
    
    public static int[] reader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = null;
        try {
            int N = Integer.parseInt(reader.readLine());
            String[] numberStrings = reader.readLine().split(" ");
            nums = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                nums[i] = Integer.parseInt(numberStrings[i]);
            }
        } catch (Exception e) {
        }
        
        return nums;
    }
    
    public static int maxAscLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int maxLen = 0;
        int[] subMax = new int[nums.length];
        for (int i = 0; i < subMax.length; i++) {
            subMax[i] = 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (subMax[j] > max && nums[i] > nums[j]) {
                    max = subMax[j];
                }
            }
            subMax[i] = max + 1;
            if (subMax[i] > maxLen) {
                maxLen = subMax[i];
            }
        }
        
        return maxLen;
    }
}