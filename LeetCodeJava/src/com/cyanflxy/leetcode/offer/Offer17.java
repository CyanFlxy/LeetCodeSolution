package com.cyanflxy.leetcode.offer;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int max = 0;
        while (n > 0) {
            max = max * 10 + 9;
            n--;
        }

        int[] result = new int[max];

        for (int i = 0; i < max; i++) {
            result[i] = i + 1;
        }

        return result;
    }
}
