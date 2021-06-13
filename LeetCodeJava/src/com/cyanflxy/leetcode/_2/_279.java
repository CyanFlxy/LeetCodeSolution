package com.cyanflxy.leetcode._2;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.06.13
 */
public class _279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;

        for (int i = 0; i * i <= n; i++) {
            int s = i * i;
            for (int j = s; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - s] + 1);
            }
        }
        return dp[n];

    }
}
