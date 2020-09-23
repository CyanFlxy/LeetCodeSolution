package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _453 {
    public int minMoves(int[] nums) {
        int total = 0;
        int min = nums[0];

        for (int n : nums) {
            total += n;
            min = Math.min(min, n);
        }

        return total - min * nums.length;
    }
}
