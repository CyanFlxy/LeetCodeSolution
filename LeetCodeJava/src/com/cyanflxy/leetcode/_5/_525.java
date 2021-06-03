package com.cyanflxy.leetcode._5;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.06.03
 */
public class _525 {
    public int findMaxLength(int[] nums) {
        int len = nums.length + 1;
        int[] map = new int[len * 2];
        Arrays.fill(map, -2);
        map[len] = -1;

        int zero = 0;
        int one = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                zero++;
            } else {
                one++;
            }

            int diff = one - zero + len;
            if (map[diff] > -2) {
                max = Math.max(max, i - map[diff]);
            } else {
                map[diff] = i;
            }
        }

        return max;
    }
}
