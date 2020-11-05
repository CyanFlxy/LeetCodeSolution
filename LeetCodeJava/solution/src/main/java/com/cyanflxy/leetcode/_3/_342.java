package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/5
 */
public class _342 {
    public boolean isPowerOfFour(int num) {
        while (num >= 4) {
            if ((num & 3) != 0) {
                return false;
            }
            num >>= 2;
        }

        return num == 1;
    }
}
