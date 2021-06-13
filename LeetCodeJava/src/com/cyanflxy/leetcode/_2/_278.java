package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2021.06.13
 */
public abstract class _278 {
    public int firstBadVersion(int n) {
        int l = 1;
        int h = n;

        while (l < h) {
            int m = (l + h) >>> 1;
            if (isBadVersion(m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    abstract boolean isBadVersion(int version);
}
