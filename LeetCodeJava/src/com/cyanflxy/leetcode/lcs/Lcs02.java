package com.cyanflxy.leetcode.lcs;

import java.util.*;

/**
 * @author cyanflxy
 * @since 2021.07.15
 */
public class Lcs02 {
    public int halfQuestions(int[] questions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : questions) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int n = questions.length / 2;
        int result = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            n -= list.get(i);
            result++;
            if (n <= 0) {
                break;
            }
        }
        return result;
    }
}
