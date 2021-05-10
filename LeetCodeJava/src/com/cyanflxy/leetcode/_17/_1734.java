package com.cyanflxy.leetcode._17;

/**
 * @author cyanflxy
 * @since 2021.05.11
 */
public class _1734 {
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int all = 0;
        for (int i = 0; i < len; i += 2) {
            all ^= encoded[i];
            all ^= i + 1;
            all ^= i + 2;
        }

        all ^= len + 1;
        int[] result = new int[len + 1];
        result[len] = all;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = encoded[i] ^ result[i + 1];
        }

        return result;
    }
}
