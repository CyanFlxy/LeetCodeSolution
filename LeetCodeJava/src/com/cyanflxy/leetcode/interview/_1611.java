package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.07.15
 */
public class _1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] result = new int[k + 1];
        result[0] = k * shorter;
        int step = longer - shorter;
        for (int i = 1; i <= k; i++) {
            result[i] = result[i - 1] + step;
        }
        return result;
    }
}
