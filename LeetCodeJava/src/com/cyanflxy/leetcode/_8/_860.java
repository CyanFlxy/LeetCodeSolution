package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _860 {
    public boolean lemonadeChange(int[] bills) {
        int c5 = 0;
        int c10 = 0;

        for (int b : bills) {
            if (b == 5) {
                c5++;
            } else if (b == 10) {
                if (c5 > 0) {
                    c5--;
                    c10++;
                } else {
                    return false;
                }
            } else {
                if (c10 > 0 && c5 > 0) {
                    c10--;
                    c5--;
                } else if (c5 >= 3) {
                    c5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
