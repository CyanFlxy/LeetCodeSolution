package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * Created by cyanflxy on 2018/3/25.
 */

public class _73_Set_Matrix_Zeroes {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _73_Set_Matrix_Zeroes object = new _73_Set_Matrix_Zeroes();

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {1, 0, 3},
                {1, 2, 3},
        };

        object.setZeroes(matrix);

        for (int[] l : matrix) {
            System.out.println(Arrays.toString(l));
        }
        System.out.println();

    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] m0 = new boolean[m];
        boolean[] n0 = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    m0[i] = true;
                    n0[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (m0[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < n; j++) {
            if (n0[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
