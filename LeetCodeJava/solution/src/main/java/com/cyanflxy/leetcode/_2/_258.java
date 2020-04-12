package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/4/12
 */
public class _258 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = num % 9;
        return result == 0 ? 9 : result;
    }
}
