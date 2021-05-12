package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2021.05.13
 */
public class _1269 {

    public int numWays(int steps, int arrLen) {
        int max = Math.min((steps) / 2 + 1, arrLen);
        int[] dp1 = new int[max + 2];
        int[] dp2 = new int[max + 2];

        int mod = 10_0000_0007;
        dp1[1] = 1;

        for (int s = 0; s < steps; s++) {
            for (int i = 1; i <= max; i++) {
                dp2[i] = ((dp1[i - 1] + dp1[i]) % mod + dp1[i + 1]) % mod;
            }
            int[] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
        }

        return dp1[1];
    }
}
