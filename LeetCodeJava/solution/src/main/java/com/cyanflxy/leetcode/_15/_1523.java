package com.cyanflxy.leetcode._15;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _1523 {
    public int countOdds(int low, int high) {
        int result = (high - low) / 2;
        result += (low & 1) | (high & 1);
        return result;
    }
}
