package com.cyanflxy.leetcode._5;

public class _542 {

    public static void main(String[] args) {
        new _542().updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        });
    }

    private int[][] result;
    private int row;
    private int col;

    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    exploreFrom(i, j, 0);
                }
            }
        }

        return result;
    }

    private void exploreFrom(int r, int c, int value) {
        if (value != 0 && value >= result[r][c]) {
            return;
        }

        result[r][c] = value;
        if (r > 0) {
            exploreFrom(r - 1, c, value + 1);
        }
        if (r < row - 1) {
            exploreFrom(r + 1, c, value + 1);
        }
        if (c > 0) {
            exploreFrom(r, c - 1, value + 1);
        }
        if (c < col - 1) {
            exploreFrom(r, c + 1, value + 1);
        }
    }
}
