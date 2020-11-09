package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2019/12/21
 */
public class _994 {

    public int orangesRotting(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    rottingFrom(grid, r, c, -1);
                }
            }
        }

        int min = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int value = grid[r][c];
                if (value == 1) {
                    return -1;
                } else if (value < min) {
                    min = value;
                }
            }
        }

        return -min;
    }

    private void rottingFrom(int[][] grid, int row, int col, int rottingTo) {
        rotting(grid, row - 1, col, rottingTo);
        rotting(grid, row + 1, col, rottingTo);
        rotting(grid, row, col - 1, rottingTo);
        rotting(grid, row, col + 1, rottingTo);
    }

    private void rotting(int[][] grid, int row, int col, int rottingTo) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return;
        }

        int state = grid[row][col];
        if (state == 1 || state < rottingTo) {
            grid[row][col] = rottingTo;
            rottingFrom(grid, row, col, rottingTo - 1);
        }
    }
}
