package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2021.05.24
 */
public class _664 {

    public int strangePrinter(String s) {
        int len = s.length();
        int[][] f = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            f[i][i] = 1;

            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = min;
                }
            }
        }

        return f[0][len - 1];
    }

}
