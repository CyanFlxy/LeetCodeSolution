package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.11
 */
public class _779 {
    public int kthGrammar(int n, int k) {
        int val = k & 1;
        k >>= 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                val = 1 - val;
            }
            k >>= 1;
        }

        return val;
    }
}
