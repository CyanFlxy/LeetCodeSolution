package com.cyanflxy.leetcode._6;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.02
 */
public class _636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        Deque<Integer> record = new LinkedList<>();

        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);

            if ("start".equals(split[1])) {
                record.push(id);
                record.push(time);
            } else {
                int middle = 0;
                while (true) {
                    int pt = record.pop();
                    int pi = record.pop();
                    if (pi == id) {
                        int t = time - pt + 1;
                        result[id] += t - middle;
                        record.push(-1);
                        record.push(t);
                        break;
                    } else {
                        middle += pt;
                    }
                }
            }
        }

        return result;
    }
}
