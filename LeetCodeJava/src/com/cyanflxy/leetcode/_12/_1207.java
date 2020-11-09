package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2020/10/28
 */
public class _1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] shownTimes = new int[2001];
        for (int n : arr) {
            shownTimes[n + 1000]++;
        }

        boolean[] shown = new boolean[arr.length + 1];
        for (int n : shownTimes) {
            if (n != 0) {
                if (shown[n]) {
                    return false;
                }
                shown[n] = true;
            }
        }
        return true;
    }
}
