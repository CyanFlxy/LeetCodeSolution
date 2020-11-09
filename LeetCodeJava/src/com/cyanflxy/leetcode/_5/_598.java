package com.cyanflxy.leetcode._5;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _598 {
    public int maxCount(int m, int n, int[][] ops) {
        int mm = m;
        int mn = n;

        for (int[] p : ops) {
            mm = Math.min(mm, p[0]);
            mn = Math.min(mn, p[1]);
        }

        return mm * mn;
    }
}
