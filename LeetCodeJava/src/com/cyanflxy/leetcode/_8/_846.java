package com.cyanflxy.leetcode._8;

import java.util.TreeMap;

/**
 * @author cyanflxy
 * @since 2021.05.28
 */
public class _846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first; i < groupSize + first; i++) {
                Integer count = map.get(i);
                if (count == null) {
                    return false;
                } else {
                    if (count > 1) {
                        map.put(i, count - 1);
                    } else {
                        map.remove(i);
                    }
                }
            }
        }
        return true;
    }
}
