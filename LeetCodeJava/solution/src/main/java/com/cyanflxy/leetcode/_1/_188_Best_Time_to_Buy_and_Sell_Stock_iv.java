package com.cyanflxy.leetcode._1;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * <p>
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _188_Best_Time_to_Buy_and_Sell_Stock_iv {

    public static void main(String... args) {
        int result = new _188_Best_Time_to_Buy_and_Sell_Stock_iv().maxProfit(1, new int[]{1, 2});
        System.out.println(result);
    }

    /**
     * 参考这里 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     */
    public int maxProfit(int K, int[] P) {
        if (P == null || P.length <= 1 || K <= 0) {
            return 0;
        }
        if (K > P.length / 2) {
            return maxProfit(P);
        }

        int[] a = new int[K + 1];
        int[] b = new int[K + 1];

        for (int i = 0; i <= K; i++) {
            a[i] = 0;
            b[i] = -P[0];
        }

        for (int i = 1; i < P.length; i++) {
            int p = P[i];
            for (int k = K; k > 0; k--) {
                a[k] = Math.max(a[k], b[k] + p);
                b[k] = Math.max(b[k], a[k - 1] - p);
            }
        }

        return a[K];
    }

    private int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int value = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            value += Math.max(0, prices[i] - prices[i - 1]);
        }
        return value;
    }
}