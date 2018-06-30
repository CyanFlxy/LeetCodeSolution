package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 * <p>
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * <pre>
 * [
 *      [ 1, 2, 3 ],
 *      [ 8, 9, 4 ],
 *      [ 7, 6, 5 ]
 * ]
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/3/14.
 */

public class _59_Spiral_Matrix_II {

    public static void main(String... args) {
        test(1);
        test(2);
        test(3);
        test(4);
    }

    private static void test(int n) {
        _59_Spiral_Matrix_II object = new _59_Spiral_Matrix_II();
        int[][] result = object.generateMatrix(n);

        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
    }

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] result = new int[n][n];

        int min = 0;
        int max = n - 1;
        int value = 1;

        while (min < max) {

            for (int k = min; k < max; k++) {
                result[min][k] = value++;
            }

            for (int k = min; k < max; k++) {
                result[k][max] = value++;
            }

            for (int k = max; k > min; k--) {
                result[max][k] = value++;
            }

            for (int k = max; k > min; k--) {
                result[k][min] = value++;
            }

            min++;
            max--;
        }

        if (min == max) {
            result[min][min] = value;
        }

        return result;
    }
}
