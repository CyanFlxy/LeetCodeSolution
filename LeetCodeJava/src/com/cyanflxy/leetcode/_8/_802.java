package com.cyanflxy.leetcode._8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.22
 */
public class _802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        boolean[] checked = new boolean[len];

        for (int i = 0; i < len; i++) {
            checked[i] = graph[i].length == 0;
        }

        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < len; i++) {
                if (!checked[i]) {
                    int[] p = graph[i];
                    boolean end = true;
                    for (int k : p) {
                        if (!checked[k]) {
                            end = false;
                            break;
                        }
                    }
                    if (end) {
                        changed = true;
                        checked[i] = true;
                    }
                }
            }
        } while (changed);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (checked[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
