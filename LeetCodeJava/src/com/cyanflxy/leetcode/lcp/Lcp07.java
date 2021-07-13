package com.cyanflxy.leetcode.lcp;

/**
 * https://leetcode-cn.com/problems/guess-numbers/
 *
 * @author cyanflxy
 * @since 2020/8/23
 */
public class Lcp07 {
    public int numWays(int n, int[][] relation, int k) {
        int[] count = new int[n];
        count[0] = 1;

        for (int i = 0; i < k; i++) {
            int[] tmp = new int[n];
            for (int[] r : relation) {
                tmp[r[1]] += count[r[0]];
            }
            count = tmp;
        }

        return count[n - 1];
    }
}
