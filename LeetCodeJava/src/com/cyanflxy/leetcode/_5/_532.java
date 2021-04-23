package com.cyanflxy.leetcode._5;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class _532 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Pair<Integer, Integer>> result = new HashSet<>();
        for (int n : nums) {
            if (!visited.contains(n) || k == 0) {
                if (visited.contains(n - k)) {
                    result.add(new Pair<>(n - k, n));
                }
                if (visited.contains(n + k)) {
                    result.add(new Pair<>(n, n + k));
                }

                visited.add(n);
            }
        }
        return result.size();
    }
}
