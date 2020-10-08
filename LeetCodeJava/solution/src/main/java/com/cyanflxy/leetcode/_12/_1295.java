package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _1295 {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int n : nums) {
            if (n >= 10 && n <= 99) {
                count++;
            } else if (n >= 1000 && n <= 9999) {
                count++;
            } else if (n >= 100000 && n <= 999999) {
                count++;
            }
        }

        return count;

    }
}
