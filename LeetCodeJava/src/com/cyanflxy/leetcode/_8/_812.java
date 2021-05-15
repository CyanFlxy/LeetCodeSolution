package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.15
 */
public class _812 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{35, -23}, {-12, -48}, {-34, -40}, {21, -25}, {-35, -44}, {24, 1}, {16, -9}, {41, 4}, {
                -36, -49}, {42, -49}, {-37, -20}, {-35, 11}, {-2, -36}, {18, 21}, {18, 8}, {-24, 14}, {-23, -11}, {-8, 44}, {-19, -3}, {
                0, -10}, {-21, -4}, {23, 18}, {20, 11}, {-42, 24}, {6, -19}};
        double d = new _812().largestTriangleArea(points);
        System.out.println(d);
    }

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        int len = points.length;
        for (int i = 0; i < len - 2; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < len - 1; j++) {
                int[] p2 = points[j];
                for (int k = j + 1; k < len; k++) {
                    int[] p3 = points[k];
                    double area = getTriangleArea(p1, p2, p3);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private double getTriangleArea(int[] p1, int[] p2, int[] p3) {
        double a = len(p1, p2);
        double b = len(p1, p3);
        double c = len(p2, p3);
        double p = (a + b + c) / 2;
        double x = p * (p - a) * (p - b) * (p - c);
        if (x <= 0) {
            return 0;
        }

        return Math.sqrt(x);
    }

    private double len(int[] p1, int[] p2) {
        int a = p1[0] - p2[0];
        int b = p1[1] - p2[1];
        return Math.sqrt(a * a + b * b);
    }
}
