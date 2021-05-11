package com.cyanflxy.leetcode._13;

/**
 * @author cyanflxy
 * @since 2021.05.12
 */
public class _1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        }
        return result;
    }
}
