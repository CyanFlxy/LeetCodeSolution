package com.cyanflxy.leetcode._14;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _1442 {
    public int countTriplets(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }

        int[] xor = new int[arr.length + 1];
        for (int i = 1; i < xor.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }

        int result = 0;
        for (int i = 1; i < xor.length; i++) {
            int before = xor[i - 1];
            for (int j = i + 1; j < xor.length; j++) {
                if (xor[j] == before) {
                    // 从i到j都是有效的三元组
                    result += j - i;
                }
            }
        }
        return result;
    }
}
