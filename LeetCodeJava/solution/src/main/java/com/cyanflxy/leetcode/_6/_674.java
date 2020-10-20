package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/10/20
 */
public class _674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLen++;
            } else {
                maxLen = maxLen > currentLen ? maxLen : currentLen;
                currentLen = 1;
            }
        }

        return maxLen > currentLen ? maxLen : currentLen;
    }
}
