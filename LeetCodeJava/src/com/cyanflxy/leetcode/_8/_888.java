package com.cyanflxy.leetcode._8;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/10/21
 */
public class _888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Set<Integer> bSet = new HashSet<>();

        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
            bSet.add(b);
        }

        int diff = (sumA - sumB) / 2;
        for (int a : A) {
            if (bSet.contains(a - diff)) {
                return new int[]{a, a - diff};
            }
        }

        return new int[2];

    }
}
