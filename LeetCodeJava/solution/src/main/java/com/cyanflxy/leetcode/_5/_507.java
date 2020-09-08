package com.cyanflxy.leetcode._5;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 3) {
            return false;
        }
        int result = 1;
        int i = 2;

        for (; i * i < num; i++) {
            if (num % i == 0) {
                result += i;
                result += num / i;
            }
        }

        if (i * i == num) {
            result += i;
        }
        return result == num;
    }
}
