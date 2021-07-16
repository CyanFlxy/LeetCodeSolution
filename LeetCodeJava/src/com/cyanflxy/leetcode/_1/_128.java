package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.07.16
 */
public class _128 {
    public static void main(String[] args) {
        new _128().longestConsecutive(Utils.toArray(0, 3, 7, 2, 5, 8, 4, 6, 0, 1));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Range> startMap = new HashMap<>();
        Map<Integer, Range> endMap = new HashMap<>();

        for (int n : nums) {
            if (startMap.containsKey(n) || endMap.containsKey(n)) {
                continue;
            }
            Range start = startMap.remove(n + 1);
            Range end = endMap.remove(n - 1);

            if (start != null || end != null) {
                if (start == null) {
                    end.max = n;
                    endMap.put(n, end);
                } else if (end == null) {
                    start.min = n;
                    startMap.put(n, start);
                } else {
                    end.max = start.max;
                    endMap.put(start.max, end);
                }
            } else {
                Range range = new Range(n);
                startMap.put(n, range);
                endMap.put(n, range);
            }
        }

        int max = 0;
        for (Range range : startMap.values()) {
            max = Math.max(max, range.len());
        }

        return max;
    }

    class Range {
        int min;
        int max;

        public Range(int v) {
            min = v;
            max = v;
        }

        public int len() {
            return max - min + 1;
        }
    }
}
