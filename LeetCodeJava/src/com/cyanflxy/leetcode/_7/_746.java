package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.08
 */
public class _746 {
    public static void main(String[] args) {
        int result = new _746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        int last0 = cost[0];
        int last1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int t = Math.min(last1 + cost[i], last0 + cost[i]);
            last0 = last1;
            last1 = t;
        }
        return Math.min(last1, last0);
    }
}
