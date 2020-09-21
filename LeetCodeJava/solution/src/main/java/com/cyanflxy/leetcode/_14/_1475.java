package com.cyanflxy.leetcode._14;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/9/21
 */
public class _1475 {

    public static void main(String... args) {
        int[] prices = {8, 7, 4, 2, 8, 1, 7, 7, 10, 1};
        int[] result = new _1475().finalPrices(prices);
        System.out.println(Arrays.toString(result));
    }

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        boolean[] seted = new boolean[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int v = prices[i];

            for (int j = i - 1; j >= 0; j--) {
                if (!seted[j] && result[j] >= v) {
                    result[j] -= v;
                    seted[j] = true;
                }
            }

            result[i] = v;
        }

        return result;
    }

}
