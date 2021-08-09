package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.08.09
 */
public class _1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row < matrix.length) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
