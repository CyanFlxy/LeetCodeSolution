package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _371 {
    public int getSum(int a, int b) {
        int result = 0;

        int carry = 0;
        int index = 1;
        for (int i = 0; i < 32; i++) {
            int i1 = (a & index) >> i;
            int i2 = (b & index) >> i;

            int v = i1 ^ i2 ^ carry;
            if (v == 1) {
                carry = i1 & i2 & carry;
            } else {
                carry = i1 | i2 | carry;
            }

            index <<= 1;
            result |= v << i;
        }

        return result;
    }
}
