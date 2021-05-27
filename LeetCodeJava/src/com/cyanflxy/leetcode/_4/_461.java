package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2021.05.27
 */
public class _461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
