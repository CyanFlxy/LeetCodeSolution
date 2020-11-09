package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _868 {
    public int binaryGap(int N) {
        if (N == 0) {
            return 0;
        }

        while ((N & 1) == 0) {
            N >>= 1;
        }
        N >>= 1;

        int max = 0;
        int current = 0;

        while (N > 0) {
            current++;
            if ((N & 1) != 0) {
                max = Math.max(max, current);
                current = 0;
            }
            N >>= 1;
        }

        return max;
    }
}
