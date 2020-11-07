package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _367 {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num <= 1) {
            return true;
        }

        double p = 0;
        double r = 1;
        while (Math.abs(p - r) >= 1) {
            p = r;
            r = (p + num / p) / 2;
        }

        int sqrt = (int) r;

        return sqrt * sqrt == num;
    }
}
