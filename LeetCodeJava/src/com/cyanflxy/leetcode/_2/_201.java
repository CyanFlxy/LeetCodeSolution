package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/8/11
 */
public class _201 {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }
}
