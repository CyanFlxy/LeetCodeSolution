package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        if (x1 == x2) {
            return y1 != y2 && x1 != x3;
        }
        if (y1 == y2) {
            return y1 != y3;
        }

        int kt = x2 * y1 - y2 * x1;
        int b = x2 - x1;
        int at = y2 - y1;
        return y3 * b != at * x3 + kt;
    }
}
