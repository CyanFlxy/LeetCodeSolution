package com.cyanflxy.leetcode._1;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String... args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minValue = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            }
            profit = Math.max(profit, prices[i] - minValue);
        }

        return Math.max(profit, 0);
//        return maxProfit(prices, 0, prices.length);
    }

    public int maxProfit(int[] prices, int from, int to) {
        if (from >= to - 1) {
            return 0;
        }

        int minValue = prices[from];
        int maxValue = prices[from];
        int minIndex = from;
        int maxIndex = from;

        for (int i = from; i < to; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
                minIndex = i;
            }

            if (prices[i] > maxValue) {
                maxValue = prices[i];
                maxIndex = i;
            }
        }

        if (minIndex <= maxIndex) {
            return maxValue - minValue;
        } else {
            int left = maxProfit(prices, from, maxIndex + 1);
            int middle = maxProfit(prices, maxIndex + 1, minIndex);
            int right = maxProfit(prices, minIndex, to);
            return Math.max(left, Math.max(middle, right));
        }

    }
}