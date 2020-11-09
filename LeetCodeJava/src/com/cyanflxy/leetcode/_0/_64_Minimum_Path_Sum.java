package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example 1:
 * <pre>
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * </pre>
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * <p>
 * Created by cyanflxy on 2018/3/15.
 */

public class _64_Minimum_Path_Sum {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _64_Minimum_Path_Sum object = new _64_Minimum_Path_Sum();
        System.out.println(object.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
                {7, 8, 0}
        }));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
