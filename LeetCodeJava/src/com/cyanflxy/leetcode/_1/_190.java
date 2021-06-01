package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2021.06.01
 */
public class _190 {
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r = (r << 1) | (n & 1);
            n >>= 1;
        }
        return r;
    }
}
