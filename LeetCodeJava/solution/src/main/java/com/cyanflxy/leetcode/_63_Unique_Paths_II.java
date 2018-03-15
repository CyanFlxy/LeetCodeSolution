package com.cyanflxy.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 * <p>
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <pre>
 * [
 *      [0,0,0],
 *      [0,1,0],
 *      [0,0,0]
 * ]
 * </pre>
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Created by cyanflxy on 2018/3/15.
 */

public class _63_Unique_Paths_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _63_Unique_Paths_II object = new _63_Unique_Paths_II();
        System.out.println(object.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }

        int n = obstacleGrid[0].length;
        if (n == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], 0);
        }
        result[0][0] = 1;

        //第一行
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            result[0][i] = 1;
        }

        //第一列
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            result[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        return result[m - 1][n - 1];
    }

}

