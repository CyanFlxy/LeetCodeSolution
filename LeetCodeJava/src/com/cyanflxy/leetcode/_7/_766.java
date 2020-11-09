package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
