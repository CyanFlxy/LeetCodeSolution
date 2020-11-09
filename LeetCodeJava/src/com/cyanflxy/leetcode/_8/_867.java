package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2020/8/26
 */
public class _867 {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}
