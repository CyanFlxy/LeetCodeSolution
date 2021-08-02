package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.08.02
 */
public class _56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>(intervals.length);
        int[] last = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];

            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                list.add(last);
                last = cur;
            }
        }

        list.add(last);

        return list.toArray(new int[0][0]);
    }
}
