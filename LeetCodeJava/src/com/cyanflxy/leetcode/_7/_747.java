package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _747 {
    public int dominantIndex(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return 0;
        }

        int max = 0;
        int sm = 0;
        int mi = -1;

        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                mi = i;
                sm = max;
                max = nums[i];
            } else if (nums[i] > sm) {
                sm = nums[i];
            }
        }

        return max >= sm * 2 ? mi : -1;
    }
}
