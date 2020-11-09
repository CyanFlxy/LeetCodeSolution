package com.cyanflxy.leetcode._1;

/**
 * https://leetcode-cn.com/problems/gas-station/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _134 {

    public static void main(String... args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;

        int maxFrom = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int gi = gas[i];
            int ci = cost[i];

            totalGas += gi;
            totalCost += ci;

            if (maxDiff <= 0) {
                maxDiff = 0;
                maxFrom = i;
            }
            maxDiff = maxDiff + (gi - ci);

        }

        if (totalGas < totalCost) {
            return -1;
        }

        return maxFrom;
    }

}