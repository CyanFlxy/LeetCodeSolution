package com.cyanflxy.leetcode._10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.05.29
 */
public class _1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        Map<Integer, Integer> sums = new HashMap<>();
        int[] sum = new int[c];
        int result = 0;
        for (int i = 0; i < r; i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j < r; j++) {
                int last = 0;
                sums.clear();
                sums.put(0, 1);
                for (int k = 0; k < c; k++) {
                    last += matrix[j][k];
                    sum[k] += last;
                    int s = sum[k];
                    result += sums.getOrDefault(s - target, 0);
                    sums.put(s, sums.getOrDefault(s, 0) + 1);
                }
            }
        }

        return result;
    }

}
