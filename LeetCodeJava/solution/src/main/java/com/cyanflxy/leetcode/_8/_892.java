package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _892 {

    // 3ms方案：拆分循环中的if，可以加快1ms。
    public int surfaceArea(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;

        int c = grid[0][0];
        if (c != 0) {
            result += c * 6 - (c - 1) * 2;
        }

        for (int j = 1; j < col; j++) {
            c = grid[0][j];
            if (c == 0) {
                continue;
            }

            result += c * 6 - (c - 1) * 2;
            result -= Math.min(grid[0][j - 1], c) * 2;
        }

        for (int i = 1; i < row; i++) {
            c = grid[i][0];
            if (c != 0) {
                result += c * 6 - (c - 1) * 2;
                result -= Math.min(grid[i - 1][0], c) * 2;
            }

            for (int j = 1; j < col; j++) {
                c = grid[i][j];
                if (c == 0) {
                    continue;
                }

                result += c * 6 - (c - 1) * 2;
                result -= Math.min(grid[i - 1][j], c) * 2;
                result -= Math.min(grid[i][j - 1], c) * 2;
            }
        }

        return result;
    }

    // 4ms方案
    public int surfaceArea2(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int c = grid[i][j];
                if (c == 0) {
                    continue;
                }
                result += c * 6 - (c - 1) * 2;

                if (i > 0) {
                    int top = grid[i - 1][j];
                    result -= Math.min(top, c) * 2;
                }

                if (j > 0) {
                    int left = grid[i][j - 1];
                    result -= Math.min(left, c) * 2;
                }
            }
        }

        return result;
    }
}
