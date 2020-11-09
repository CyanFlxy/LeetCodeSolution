package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _441 {
    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }
}
