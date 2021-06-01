package com.cyanflxy.leetcode._17;

/**
 * @author cyanflxy
 * @since 2021.06.01
 */
public class _1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] result = new boolean[q];
        for (int i = 0; i < q; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];

            long min = day;// 这天至少需要吃这些，
            long max = cap * (day + 1L);// 这些天最多能吃到这些
            long targetMin = sum[type];
            long targetMax = sum[type + 1];

            result[i] = min < targetMax && max > targetMin;
        }

        return result;
    }

}
