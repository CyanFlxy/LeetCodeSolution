package com.cyanflxy.leetcode._8;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author cyanflxy
 * @since 2021.05.17
 */
public class _874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int signX = 0;
        int signY = 1;

        Map<Integer, TreeSet<Integer>> xMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yMap = new HashMap<>();
        for (int[] o : obstacles) {
            int px = o[0];
            int py = o[1];

            TreeSet<Integer> xSet = xMap.computeIfAbsent(px, integer -> new TreeSet<>());
            xSet.add(py);

            TreeSet<Integer> ySet = yMap.computeIfAbsent(py, integer -> new TreeSet<>());
            ySet.add(px);
        }

        int max = 0;

        for (int c : commands) {
            if (c > 0) {
                if (signX == 0) {
                    y = getStep(y, y + c * signY, xMap.get(x));
                } else {
                    x = getStep(x, x + c * signX, yMap.get(y));
                }
                max = Math.max(max, x * x + y * y);
            } else {
                if (c == -1) {// 右转
                    if (signX == 0) {
                        signX = signY;// 向上或向下，均导致SignX方向与当前Y方向一致
                        signY = 0;
                    } else {
                        signY = -signX;
                        signX = 0;
                    }
                } else {// 左转
                    if (signX == 0) {
                        signX = -signY;// 向上或向下，均导致SignX方向与当前Y方向不一致
                        signY = 0;
                    } else {
                        signY = signX;
                        signX = 0;
                    }
                }
            }
        }

        return max;
    }

    private int getStep(int from, int to, TreeSet<Integer> set) {
        if (set == null) {
            return to;
        }

        if (from > to) {
            Integer next = set.lower(from);
            if (next == null || next < to) {
                return to;
            } else {
                return next + 1;
            }
        } else {
            Integer next = set.higher(from);
            if (next == null || next > to) {
                return to;
            } else {
                return next - 1;
            }
        }
    }
}
