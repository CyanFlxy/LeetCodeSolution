package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _326 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
