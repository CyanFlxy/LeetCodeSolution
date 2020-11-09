package com.cyanflxy.leetcode._15;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        for (int n : nums) {
            counts[n]++;
        }

        int result = 0;
        for (int c : counts) {
            if (c >= 2) {
                result += (c * (c - 1)) / 2;
            }
        }

        return result;
    }
}
