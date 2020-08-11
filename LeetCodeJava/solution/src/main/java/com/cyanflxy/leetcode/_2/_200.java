package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/8/11
 */
public class _200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    fillIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void fillIsland(char[][] grid, int i, int j) {
        grid[i][j] = 'X';
        if (i > 0 && grid[i - 1][j] == '1') {
            fillIsland(grid, i - 1, j);
        }

        if (j > 0 && grid[i][j - 1] == '1') {
            fillIsland(grid, i, j - 1);
        }

        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            fillIsland(grid, i + 1, j);
        }

        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
            fillIsland(grid, i, j + 1);
        }

    }
}
