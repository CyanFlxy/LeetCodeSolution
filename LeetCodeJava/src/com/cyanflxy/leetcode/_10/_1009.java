package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _1009 {
    public int bitwiseComplement(int num) {
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
