package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/1
 */
public class _1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;

        int n = points.length;
        int lastX = points[0][0], lastY = points[0][1];
        int curX, curY;

        for (int i = 1; i < n; i++) {
            curX = points[i][0];
            curY = points[i][1];

            result += Math.max(Math.abs(curX - lastX), Math.abs(curY - lastY));

            lastX = curX;
            lastY = curY;
        }

        return result;
    }
}
