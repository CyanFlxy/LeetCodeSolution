package com.cyanflxy.leetcode._8;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.21
 */
public class _821 {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] result = new int[len];
        Arrays.fill(result, len);
        char[] arr = s.toCharArray();
        int dist = len;

        for (int i = 0; i < len; i++) {
            char ch = arr[i];
            if (ch == c) {
                result[i] = 0;
                dist = 0;

                for (int j = i - 1; j >= 0; j--) {
                    int d = i - j;
                    if (result[j] > d) {
                        result[j] = d;
                    } else {
                        break;
                    }
                }

            } else {
                result[i] = ++dist;
            }
        }

        return result;
    }
}
