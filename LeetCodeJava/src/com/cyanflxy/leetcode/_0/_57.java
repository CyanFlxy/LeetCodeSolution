package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.08.02
 */
public class _57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length);

        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (newInterval == null) {
                list.add(cur);
                continue;
            }

            if (cur[1] < newInterval[0]) {
                list.add(cur);
            } else if (cur[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = null;
                list.add(cur);
            } else {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }

        }

        if (newInterval != null) {
            list.add(newInterval);
        }

        return list.toArray(new int[0][]);
    }
}
