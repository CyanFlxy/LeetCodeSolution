package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
 * <p>
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well.
 * <p>
 * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
 * <p>
 * What is the maximum total sum that the height of the buildings can be increased?
 * <pre>
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation:
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 *
 * The skyline viewed from top or bottom is: [9, 4, 8, 7]
 * The skyline viewed from left or right is: [8, 7, 9, 3]
 *
 * The grid after increasing the height of buildings without affecting skylines is:
 *
 * gridNew = [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 * </pre>
 * Notes:
 * <p>
 * 1 < grid.length = grid[0].length <= 50.<br>
 * All heights grid[i][j] are in the range [0, 100].<br>
 * All buildings in grid[i][j] occupy the entire grid cell:
 * that is, they are a 1 x 1 x grid[i][j] rectangular prism.<br>
 * <p>
 * Created by cyanflxy on 2018/4/1.
 */

public class _807_Max_Increase_to_Keep_City_Skyline {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _807_Max_Increase_to_Keep_City_Skyline object = new _807_Max_Increase_to_Keep_City_Skyline();

        System.out.println(object.maxIncreaseKeepingSkyline(new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}}
        ));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] h = new int[len];
        int[] v = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                h[i] = Math.max(h[i], grid[j][i]);
                v[i] = Math.max(v[i], grid[i][j]);
            }
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int g = grid[i][j];
                result += Math.max(g, Math.min(h[j], v[i])) - g;
            }
        }

        return result;
    }

}
