package com.cyanflxy.leetcode._13;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _1317 {
    public int[] getNoZeroIntegers(int n) {
        if (n < 10) {
            return new int[]{1, n - 1};
        }
        int k = 0;
        int i = 1;

        while (n > i * 10) {
            int x = n / i % 10;
            if (x != 1) {
                k += i;
                n -= i;
            } else {
                k += i * 2;
                n -= i * 2;
            }
            i *= 10;
        }

        return new int[]{k, n};
    }
}
