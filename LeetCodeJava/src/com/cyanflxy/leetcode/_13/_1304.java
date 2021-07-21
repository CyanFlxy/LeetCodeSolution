package com.cyanflxy.leetcode._13;

/**
 * @author cyanflxy
 * @since 2021.07.22
 */
public class _1304 {

    public static void main(String[] args) {
        new _1304().sumZero(5);
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];

        int edge = n / 2;

        for (int i = 0; i < edge; i++) {
            result[i] = -edge + i;
        }
        for (int i = n - 1; i > edge; i--) {
            result[i] = edge - (n - i - 1);
        }
        return result;
    }
}
