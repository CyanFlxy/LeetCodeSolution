package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _908 {
    public int smallestRangeI(int[] A, int K) {
        if (A == null || A.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : A) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        return Math.max(max - min - K * 2, 0);
    }
}
