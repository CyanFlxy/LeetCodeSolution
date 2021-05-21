package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2021.05.21
 */
public class _1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[l1][l2];
    }
}
