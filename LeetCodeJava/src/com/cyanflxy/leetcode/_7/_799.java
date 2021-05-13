package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.13
 */
public class _799 {
    public static void main(String[] args) {
        double result;
//        result = new _799().champagneTower(6, 3, 2);

        result = new _799().champagneTower(25, 6, 1);
        System.out.println(result);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 2];
        double[] dp1 = new double[query_row + 2];
        dp[1] = poured;

        for (int i = 1; i <= query_row; i++) {
            for (int j = 1; j <= i + 1; j++) {
                if (dp[j] > 1) {
                    dp1[j] = (dp[j] - 1) / 2;
                } else {
                    dp1[j] = 0;
                }
                if (dp[j - 1] > 1) {
                    dp1[j] += (dp[j - 1] - 1) / 2;
                }
            }
            double[] t = dp;
            dp = dp1;
            dp1 = t;
        }

        if (dp[query_glass + 1] > 1) {
            dp[query_glass + 1] = 1;
        }
        return dp[query_glass + 1];
    }
}
