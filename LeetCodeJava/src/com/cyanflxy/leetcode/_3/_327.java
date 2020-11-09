package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;

        long sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (lower <= sum && sum <= upper) {
                    result++;
                }
            }
        }

        return result;
    }
}
