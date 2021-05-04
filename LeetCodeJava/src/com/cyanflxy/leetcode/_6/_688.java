package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2021.05.04
 */
public class _688 {
    public static void main(String[] args) {
        new _688().knightProbability(3, 2, 0, 0);
    }

    private int[] R = {1, 1, 2, 2, -1, -1, -2, -2};
    private int[] C = {2, -2, 1, -1, 2, -2, 1, -1};

    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        dp[row][column] = 1;

        for (; k > 0; k--) {
            double[][] dp2 = new double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < 8; x++) {
                        int tx = i + R[x];
                        int ty = j + C[x];
                        if (tx >= 0 && tx < n && ty >= 0 && ty < n) {
                            dp2[tx][ty] += dp[i][j] / 8;
                        }
                    }
                }
            }

            dp = dp2;
        }

        double ans = 0;
        for (double[] rows : dp) {
            for (double x : rows) {
                ans += x;
            }
        }
        return ans;
    }

}
