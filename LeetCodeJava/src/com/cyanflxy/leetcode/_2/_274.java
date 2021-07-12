package com.cyanflxy.leetcode._2;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.07.12
 */
public class _274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
//        for (int i = len - 1; i >= 0; i--) {
//            if (citations[i] < len - i) {
//                return len - i-1;
//            }
//        }

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
