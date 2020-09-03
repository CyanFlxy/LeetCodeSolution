package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
