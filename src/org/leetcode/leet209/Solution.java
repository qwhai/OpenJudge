package org.leetcode.leet209;

/**
 * DESC:    https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * Author:  Q-Whai
 * My Blog: http://blog.csdn.net/lemon_tree12138
 * Create Date: 2016/4/18
 * Last Modify: 2016/4/18
 * version: 0.0.1
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int result = solution.minSubArrayLen(7, nums);
        System.err.println(result);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int left = 0;
        int right = left;

        int sum = 0;
        int minLength = -1; // 最小子数组长度

        do {
            if (sum < s) {
                sum += nums[right];
                right++;
                continue;
            }

            if (minLength == -1 || right - left < minLength) {
                minLength = right - left;
            }
            sum -= nums[left];
            left++;

        } while (right < length || sum >= s);

        return minLength == -1 ? 0 : minLength;
    }

    public void showSubArray(int[] array, int start, int end) {
        boolean first = true;
        for (int i = start; i <= end; i++) {
            System.out.print(first ? "" + array[i] : ", " + array[i]);
            first = false;
        }
        System.out.println();
    }
}
