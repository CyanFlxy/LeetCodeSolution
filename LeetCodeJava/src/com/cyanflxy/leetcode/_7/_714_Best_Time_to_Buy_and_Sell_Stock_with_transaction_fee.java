package com.cyanflxy.leetcode._7;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * <p>
 * <p>Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _714_Best_Time_to_Buy_and_Sell_Stock_with_transaction_fee {

    public static void main(String... args) {

    }

    public int maxProfit(int[] prices, int fee) {
        if (fee == 0) {
            return maxProfit(prices);
        }

        int a = 0;
        int b = Integer.MIN_VALUE + fee + 1;
        int tmp;

        for (int p : prices) {
            tmp = a;
            a = Math.max(a, b + p - fee);
            b = Math.max(b, tmp - p);
        }

        return a;
    }

    public int maxProfit(int[] prices) {
        int value = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            value += Math.max(0, prices[i] - prices[i - 1]);
        }
        return value;
    }
}