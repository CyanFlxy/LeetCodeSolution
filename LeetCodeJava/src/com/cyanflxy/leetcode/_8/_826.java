package com.cyanflxy.leetcode._8;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.31
 */
public class _826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            dp[i][0] = difficulty[i];
            dp[i][1] = profit[i];
        }

        Arrays.sort(dp, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i][1], dp[i - 1][1]);
        }

        int result = 0;
        for (int work : worker) {
            result += searchProfit(dp, work);
        }

        return result;
    }

    private int searchProfit(int[][] dp, int work) {
        if (dp[0][0] > work) {
            return 0;
        }

        int l = 0;
        int h = dp.length - 1;
        while (l < h) {
            int mid = (l + h + 1) / 2;
            int diff = dp[mid][0];
            if (diff < work) {
                l = mid;
            } else if (diff > work) {
                h = mid - 1;
            } else {
                return dp[mid][1];
            }
        }
        return dp[l][1];
    }
}
