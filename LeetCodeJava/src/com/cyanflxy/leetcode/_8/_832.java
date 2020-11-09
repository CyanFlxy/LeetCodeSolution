package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        int mid = len / 2;
        boolean changeMid = (len & 1) == 1;

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < mid; c++) {
                int t = 1 - A[r][c];
                A[r][c] = 1 - A[r][len - c - 1];
                A[r][len - c - 1] = t;
            }

            if (changeMid) {
                A[r][mid] = 1 - A[r][mid];
            }
        }

        return A;
    }
}
