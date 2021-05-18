package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _961 {
    public int repeatedNTimes(int[] nums) {
        int[] count = new int[10001];
        for (int n : nums) {
            count[n]++;
            if (count[n] > 1) {
                return n;
            }
        }
        return 0;
    }
}
