package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.08.02
 */
public class _1617 {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int lastMin = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 1; i < sum.length; i++) {
            int s = sum[i];
            maxValue = Math.max(maxValue, s - lastMin);
            if (s < lastMin) {
                lastMin = s;
            }
        }
        return maxValue;
    }
}
