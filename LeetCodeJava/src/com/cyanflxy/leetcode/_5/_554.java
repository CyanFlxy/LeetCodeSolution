package com.cyanflxy.leetcode._5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.05.02
 */
public class _554 {

    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        int width = 0;
        for (Integer i : wall.get(0)) {
            width += i;
        }

        if (width == 1) {
            return height;
        }

        Map<Integer, Integer> gapMap = new HashMap<>();
        for (List<Integer> line : wall) {
            int index = 0;
            for (Integer i : line) {
                index += i;
                gapMap.put(index, gapMap.getOrDefault(index, 0) + 1);
            }
        }

        gapMap.remove(width);

        int max = 0;
        for (Integer i : gapMap.values()) {
            max = Math.max(max, i);
        }
        return height - max;
    }
}
