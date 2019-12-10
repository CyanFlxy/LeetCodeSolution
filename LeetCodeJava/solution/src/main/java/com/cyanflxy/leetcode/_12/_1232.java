package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/10
 */
public class _1232 {

    public static void main(String... args) {
        boolean b = new _1232().checkStraightLine(new int[][]{{1, 2}, {3, 4}, {2, 3},});
        System.out.println(b);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        int curX = coordinates[0][0];
        int curY = coordinates[0][1];
        int lastX = coordinates[1][0];
        int lastY = coordinates[1][1];
        int dx = curX - lastX;
        int dy = curY - lastY;

        for (int i = 2; i < len; i++) {
            curX = coordinates[i][0];
            curY = coordinates[i][1];
            int cx = curX - lastX;
            int cy = curY - lastY;

            if (dx * cy != dy * cx) {
                return false;
            }

            lastX = curX;
            lastY = curY;

        }

        return true;
    }

}
