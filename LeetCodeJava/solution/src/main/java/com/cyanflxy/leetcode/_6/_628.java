package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/9/2
 */
public class _628 {

    public int maximumProduct(int[] nums) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        for (int v : nums) {

            if (v > m1) {
                m3 = m2;
                m2 = m1;
                m1 = v;
            } else if (v > m2) {
                m3 = m2;
                m2 = v;
            } else if (v > m3) {
                m3 = v;
            }
            if (v < n1) {
                n2 = n1;
                n1 = v;
            } else if (v < n2) {
                n2 = v;
            }
        }

        return Math.max(m1 * m2 * m3, m1 * n1 * n2);
    }

}
