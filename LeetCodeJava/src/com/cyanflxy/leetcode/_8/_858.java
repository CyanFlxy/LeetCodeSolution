package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.06.03
 */
public class _858 {
    public int mirrorReflection(int p, int q) {
        if (q == 0) {
            return 0;
        }

        int m = p * q / greatestCommonDivider(p, q);
        int pc = m / q;
        int qc = m / p;

        return 1 - pc % 2 + qc % 2;
    }

    private int greatestCommonDivider(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else if (b % r == 0) {
            return r;
        } else {
            return greatestCommonDivider(b, r);
        }
    }
}
