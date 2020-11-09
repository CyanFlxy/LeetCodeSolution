package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _476 {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int result = 0;
        int bit = 1;
        while (num != 0) {
            if ((num & 1) != 1) {
                result |= bit;
            }
            bit <<= 1;
            num >>= 1;
        }

        return result;
    }
}
