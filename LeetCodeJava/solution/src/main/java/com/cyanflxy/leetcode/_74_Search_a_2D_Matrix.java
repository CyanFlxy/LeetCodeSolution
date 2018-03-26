package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * <p>
 * Consider the following matrix:
 * <pre>
 * [
 *      [1,   3,  5,  7],
 *      [10, 11, 16, 20],
 *      [23, 30, 34, 50]
 * ]
 * </pre>
 * Given target = 3, return true.
 * <p>
 * Created by cyanflxy on 2018/3/26.
 */

public class _74_Search_a_2D_Matrix {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _74_Search_a_2D_Matrix object = new _74_Search_a_2D_Matrix();
        System.out.println(object.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if (target < matrix[0][0] || matrix[m - 1][n - 1] < target) {
            return false;
        }

        int s = 0;
        int e = m - 1;
        while (s <= e) {
            int c = s + (e - s) / 2;

            if (matrix[c][0] < target) {
                s = c + 1;
            } else if (matrix[c][0] > target) {
                e = c - 1;
            } else {
                return true;
            }
        }

        if (s >= m) {
            s = m - 1;
        } else if (matrix[s][0] > target) {
            if (s > 0) {
                s--;
            } else {
                return false;
            }
        }

        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int c = i + (j - i) / 2;

            if (matrix[s][c] < target) {
                i = c + 1;
            } else if (matrix[s][c] > target) {
                j = c - 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
