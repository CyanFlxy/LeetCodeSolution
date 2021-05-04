package com.cyanflxy.leetcode._14;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.04
 */
public class _1473 {

//    public static void main(String[] args) {
//        int result = new _1473().minCost(new int[]{0, 0, 0, 0, 0},
//                new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}},
//                5, 2, 3);
//        System.out.println(result);
//    }

    //    private int minCost = Integer.MAX_VALUE;
//
//    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//        int costed = 0;
//        for (int i = 0; i < m; i++) {
//            if (houses[i] != 0) {
//                costed -= cost[i][houses[i] - 1];
//            }
//        }
//
//        test(houses, cost, 0, m, n, target);
//        if (minCost == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return minCost + costed;
//    }
//
//    private void test(int[] houses, int[][] cost, int index, int m, int n, int target) {
//        int blockCount = blockCount(houses);
//        if (blockCount > target || blockCount + m - index < target) {
//            return;
//        }
//
//        int costed = 0;
//        for (int i = 0; i < m; i++) {
//            costed += cost[i][houses[i] - 1];
//        }
//        if (costed > minCost) {
//            return;
//        }
//
//        if (index >= m) {
//            if (blockCount == target) {
//                minCost = costed;
//            }
//            return;
//        }
//
//        if (houses[index] != 0) {
//            test(houses, cost, index + 1, m, n, target);
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            houses[index] = i;
//            test(houses, cost, index + 1, m, n, target);
//            houses[index] = 0;
//        }
//    }
//
//    private int blockCount(int[] houses) {
//        int last = houses[0];
//        int count = 1;
//        for (int h : houses) {
//            if (h != 0 && h != last) {
//                if (last != 0) {
//                    count++;
//                }
//                last = h;
//            }
//        }
//        return count;
//    }
// 极大值
// 选择 Integer.MAX_VALUE / 2 的原因是防止整数相加溢出
    static final int INFTY = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // 将颜色调整为从 0 开始编号，没有被涂色标记为 -1
        for (int i = 0; i < m; ++i) {
            --houses[i];
        }

        // dp 所有元素初始化为极大值
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], INFTY);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }

                for (int k = 0; k < target; ++k) {
                    for (int j0 = 0; j0 < n; ++j0) {
                        if (j == j0) {
                            if (i == 0) {
                                if (k == 0) {
                                    dp[i][j][k] = 0;
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }
                    }

                    if (dp[i][j][k] != INFTY && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }
                }
            }
        }

        int ans = INFTY;
        for (int j = 0; j < n; ++j) {
            ans = Math.min(ans, dp[m - 1][j][target - 1]);
        }
        return ans == INFTY ? -1 : ans;
    }
}
