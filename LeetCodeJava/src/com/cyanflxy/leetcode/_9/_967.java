package com.cyanflxy.leetcode._9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.06.18
 */
public class _967 {

    List<Integer> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {

        for (int i = 1; i <= 9; i++) {
            if (i >= k || i + k <= 9) {
                dfs(i, n - 1, k, 0);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void dfs(int val, int n, int k, int v) {
        v = v * 10 + val;

        if (n > 0) {
            if (val >= k) {
                dfs(val - k, n - 1, k, v);
            }
            if (k != 0 && val + k <= 9) {
                dfs(val + k, n - 1, k, v);
            }
        } else {
            list.add(v);
        }
    }
}
