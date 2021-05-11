package com.cyanflxy.leetcode._7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.05.11
 */
public class _781 {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (count <= key + 1) {
                result += key + 1;
            } else if (key == 0) {
                result += count;
            } else {
                int group = (count + key) / (key + 1);
                result += group * (key + 1);
            }
        }

        return result;
    }
}
