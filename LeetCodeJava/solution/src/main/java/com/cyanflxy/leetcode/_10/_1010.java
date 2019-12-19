package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2019/12/19
 */
public class _1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];

        for (int t : time) {
            remainder[t % 60]++;
        }

        int count = remainder[0] * (remainder[0] - 1) / 2;
        count += remainder[30] * (remainder[30] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            count += remainder[i] * remainder[60 - i];
        }
        return count;
    }
}
