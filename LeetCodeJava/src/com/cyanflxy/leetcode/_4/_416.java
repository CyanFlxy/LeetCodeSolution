package com.cyanflxy.leetcode._4;

public class _416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        if (max >= sum) {
            return max == sum;
        }

        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > n) {
                    dp[i][j] |= dp[i - 1][j - n];
                }
            }
        }

        return dp[nums.length - 1][sum];
    }

}
