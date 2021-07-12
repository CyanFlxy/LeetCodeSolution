package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2021.07.12
 */
public class _275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (citations[len - 1] == 0) {
            return 0;
        }
        int l = 0;
        int h = len - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (citations[m] >= len - m) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return len - l;
    }
}
