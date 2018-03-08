package com.cyanflxy.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/description/
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <pre>
 * Given input matrix =
 * [
 *      [1,2,3],
 *      [4,5,6],
 *      [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *      [7,4,1],
 *      [8,5,2],
 *      [9,6,3]
 * ]
 * </pre>
 * Example 2:
 * <pre>
 *
 * Given input matrix =
 * [
 *      [ 5, 1, 9,11],
 *      [ 2, 4, 8,10],
 *      [13, 3, 6, 7],
 *      [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *      [15,13, 2, 5],
 *      [14, 3, 4, 1],
 *      [12, 6, 8, 9],
 *      [16, 7,10,11]
 * ]
 *
 *     </pre>
 * Created by cyanflxy on 2018/3/8.
 */

public class _48_Rotate_Image {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _48_Rotate_Image object = new _48_Rotate_Image();

//        object.test(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});//true
        object.test(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});//true
    }

    private void test(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println();
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println();
        System.out.println();
    }

    public void rotate(int[][] matrix) {

        int size = matrix.length;
        if (size <= 1) {
            return;
        }

        int s = size - 1;
        for (int c = 0; c < (size + 1) / 2; c++) {
            for (int r = 0; r < size / 2; r++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[s - c][r];
                matrix[s - c][r] = matrix[s - r][s - c];
                matrix[s - r][s - c] = matrix[c][s - r];
                matrix[c][s - r] = temp;
            }
        }

    }
}
