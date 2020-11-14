package com.cyanflxy.leetcode._4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _403 {
    public static void main(String[] args) {
        new _403().canCross(new int[]{0, 1, 3, 4, 5, 7, 9, 10, 12});
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
        for (int n : stones) {
            map.put(n, new HashSet<>());
        }
        map.remove(0);
        map.get(1).add(1);

        for (int n : stones) {
            if (!map.containsKey(n)) {
                continue;
            }

            Set<Integer> step = map.get(n);
            for (int t : step) {
                for (int x = t - 1; x <= t + 1; x++) {
                    if (x > 0 && map.containsKey(n + x)) {
                        map.get(n + x).add(x);
                    }
                }
            }
        }

        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}
