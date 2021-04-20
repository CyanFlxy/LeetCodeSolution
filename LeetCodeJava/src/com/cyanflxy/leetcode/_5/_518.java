package com.cyanflxy.leetcode._5;

public class _518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 无论有多少钱币，如果总数为零，那么总是有且只有一种组合。

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];// 当i==coin的时候，添加的dp[0]恒为1，故不需要对dp[coin]做特殊处理
            }
        }

        return dp[amount];
    }

}
