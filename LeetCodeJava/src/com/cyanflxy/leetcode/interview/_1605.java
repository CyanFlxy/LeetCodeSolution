package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.08.02
 */
public class _1605 {
    public int trailingZeroes(int n) {
        long f = 5;
        int count = 0;
        while (n >= f) {
            count += n / f;
            f *= 5;
        }
        return count;
    }
}
