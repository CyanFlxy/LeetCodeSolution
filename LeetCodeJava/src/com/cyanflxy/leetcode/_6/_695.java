package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2021.05.03
 */
public class _695 {
    private int row;
    private int col;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, checkCount(grid, i, j, 0));
                }
            }
        }

        return max;
    }

    private int checkCount(int[][] grid, int x, int y, int count) {
        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
            grid[x][y] = 2;
            count++;

            count = checkCount(grid, x + 1, y, count);
            count = checkCount(grid, x - 1, y, count);
            count = checkCount(grid, x, y + 1, count);
            count = checkCount(grid, x, y - 1, count);
        }
        return count;
    }

}
