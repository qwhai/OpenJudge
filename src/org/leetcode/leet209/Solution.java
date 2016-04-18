package org.leetcode.leet209;

/**
 * DESC:    https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Author:  Q-Whai
 * My Blog: http://blog.csdn.net/lemon_tree12138
 * Create Date: 2016/4/18
 * Last Modify: 2016/4/18
 * version: 0.0.1
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int result = solution.minSubArrayLen(7, nums);
        System.out.println(result);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length;

        // TODO

        return -1;
    }
}
