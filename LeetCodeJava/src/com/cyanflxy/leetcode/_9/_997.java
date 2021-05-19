package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.05.19
 */
public class _997 {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] count = new int[n + 1];
        for (int[] t : trust) {
            count[t[0]] += -1000;
            count[t[1]]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
