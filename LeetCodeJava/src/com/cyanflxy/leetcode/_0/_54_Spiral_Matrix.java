package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <per>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * </per>
 * You should return [1,2,3,6,9,8,7,4,5].
 * <p>
 * Created by cyanflxy on 2018/3/14.
 */

public class _54_Spiral_Matrix {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _54_Spiral_Matrix object = new _54_Spiral_Matrix();

        System.out.println(object.spiralOrder(new int[][]{{1}}));
        System.out.println(object.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6}}));
        System.out.println(object.spiralOrder(new int[][]{{1}, {2}, {3}, {4}}));
        System.out.println(object.spiralOrder(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(object.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(object.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}}));
        System.out.println(object.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}}));
        System.out.println(object.spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}}));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max;
        if (m == n) {
            max = (m + 1) / 2;
        } else {
            max = Math.min(m, n) / 2;
        }

        for (int i = 0; i < max; i++) {
            int mm = m - 1 - i;
            int mn = n - 1 - i;

            //顶行
            for (int k = i; k <= mn; k++) {
                result.add(matrix[i][k]);
            }

            for (int k = i + 1; k <= mm; k++) {
                result.add(matrix[k][mn]);
            }

            for (int k = mn - 1; k >= i; k--) {
                result.add(matrix[mm][k]);
            }

            for (int k = mm - 1; k > i; k--) {
                result.add(matrix[k][i]);
            }

        }

        if (m > n && n % 2 == 1) {
            int c = n / 2;
            for (int k = max; k < m - max; k++) {
                result.add(matrix[k][c]);
            }
        } else if (m < n && m % 2 == 1) {
            int c = m / 2;
            for (int k = max; k < n - max; k++) {
                result.add(matrix[c][k]);
            }
        }
        return result;
    }

}
