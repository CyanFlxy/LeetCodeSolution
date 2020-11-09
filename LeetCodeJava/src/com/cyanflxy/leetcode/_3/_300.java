package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] count = new int[nums.length];

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxValue = 0;
            int current = nums[i];

            for (int j = i + 1; j < nums.length - maxValue; j++) {
                if (current < nums[j] && count[j] + 1 > maxValue) {
                    maxValue = count[j] + 1;
                }
            }
            count[i] = maxValue;
        }

        int result = 0;
        for (int i = 0; i < nums.length - result; i++) {
            if (count[i] > result) {
                result = count[i];
            }
        }

        return result + 1;
    }
}
