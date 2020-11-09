package com.cyanflxy.leetcode._13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer> sort = new ArrayList<>();
        int[] bits = new int[10001];

        for (int n : arr) {
            sort.add(n);
            bits[n] = Integer.bitCount(n);
        }


        Collections.sort(sort, (i1, i2) -> {
            if (bits[i1] != bits[i2]) {
                return bits[i1] - bits[i2];
            } else {
                return i1 - i2;
            }
        });

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = sort.get(i);
        }

        return result;
    }
}
