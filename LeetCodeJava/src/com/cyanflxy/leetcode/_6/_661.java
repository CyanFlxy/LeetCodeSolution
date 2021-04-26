package com.cyanflxy.leetcode._6;

public class _661 {

    private int r;
    private int c;

    public int[][] imageSmoother(int[][] M) {
        r = M.length;
        c = M[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = ave(M, i, j);
            }
        }
        return result;
    }

    private int ave(int[][] M, int cx, int cy) {
        int total = 0;
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = cx + i;
                int y = cy + j;
                if (x >= 0 && x < r && y >= 0 && y < c) {
                    count++;
                    total += M[x][y];
                }
            }
        }
        return total / count;
    }
}
