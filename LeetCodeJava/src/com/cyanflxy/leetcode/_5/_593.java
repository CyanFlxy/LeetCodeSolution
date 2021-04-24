package com.cyanflxy.leetcode._5;

public class _593 {

    public static void main(String[] args) {
        new _593().validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1});
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int dis12 = distance(p1, p2);
        if (dis12 == 0) {
            return false;
        }
        int dis13 = distance(p1, p3);
        int dis23 = distance(p2, p3);
        if (dis12 == dis13 && dis12 * 2 == dis23) {
            int dis24 = distance(p2, p4);
            int dis34 = distance(p3, p4);
            if (dis24 == dis34) {
                return distance(p1, p4) == dis23;
            }
        } else if (dis12 == dis23 && dis12 * 2 == dis13) {
            int dis14 = distance(p1, p4);
            int dis34 = distance(p3, p4);
            if (dis14 == dis34) {
                return distance(p2, p4) == dis13;
            }
        } else if (dis13 == dis23 && dis13 * 2 == dis12) {
            int dis14 = distance(p1, p4);
            int dis24 = distance(p2, p4);
            if (dis14 == dis24) {
                return distance(p3, p4) == dis12;
            }
        }

        return false;
    }

    // 两点距离的平方 - 不开方，避免非整数比较
    private int distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
