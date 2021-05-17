package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.17
 */
public class _883 {
    public int projectionArea(int[][] grid) {
        int result = 0;

        for (int[] gx : grid) {
            int max = 0;
            for (int x : gx) {
                max = Math.max(max, x);// X轴投影，选取当前行最高的
            }
            result += max;
        }

        int len = grid.length;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = 0; j < len; j++) {
                max = Math.max(max, grid[j][i]);// Y轴投影，选取当前行最高的
            }
            result += max;
        }

        for (int[] gx : grid) {
            for (int x : gx) {
                if (x > 0) {
                    result++; // Z轴投影
                }
            }
        }

        return result;
    }
}
