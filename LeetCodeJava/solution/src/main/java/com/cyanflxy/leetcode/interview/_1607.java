package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _1607 {
    public int maximum(int a, int b) {
        long l1 = a;
        long l2 = b;

        return (int) ((l1 + l2 + Math.abs(l1 - l2)) / 2);
    }
}
