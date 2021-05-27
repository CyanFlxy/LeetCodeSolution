package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.27
 */
public class _840 {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isMagicSquare(int[][] grid, int x, int y) {
        boolean[] count = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int v = grid[x + i][y + j];
                if (v == 0 || v > 9 || count[v]) {
                    return false;
                }
                count[v] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[x + i][y] + grid[x + i][y + 1] + grid[x + i][y + 2] != 15) {
                return false;
            }
            if (grid[x][y + i] + grid[x + 1][y + i] + grid[x + 2][y + i] != 15) {
                return false;
            }
        }

        if (grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != 15) {
            return false;
        }

        if (grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y] != 15) {
            return false;
        }
        return true;
    }
}
