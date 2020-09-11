package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2020/9/11
 */
public class _1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] nums = new int[100];

        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            int index = (a > b) ? (a * 10 + b) : (b * 10 + a);
            nums[index]++;
        }

        int total = 0;
        for (int n : nums) {
            if (n >= 2) {
                total += (n * (n - 1) / 2);
            }
        }

        return total;
    }
}
