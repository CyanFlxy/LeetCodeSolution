package com.cyanflxy.leetcode._5;

import java.util.HashSet;
import java.util.Set;

public class _575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
