package com.cyanflxy.leetcode._14;

/**
 * @author cyanflxy
 * @since 2020/9/29
 */
public class _1486 {
    public int xorOperation(int n, int start) {
        int result = start;

        for (int i = 1; i < n; i++) {
            result ^= start + i * 2;
        }

        return result;
    }
}
