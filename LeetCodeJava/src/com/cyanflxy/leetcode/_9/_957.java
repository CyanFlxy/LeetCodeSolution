package com.cyanflxy.leetcode._9;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.06.23
 */
public class _957 {
    public static void main(String[] args) {
        new _957().prisonAfterNDays(Utils.toArray(0, 1, 0, 0, 1, 0, 1, 1), 4);
    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        if (cells[0] == 1 || cells[7] == 1) {
            cells = next(cells);
            return prisonAfterNDays(cells, n - 1);
        }

        int[][] loops = new int[64][];
        int[] valueIndex = new int[64];
        int loopCount = 0;

        while (true) {
            int v = value(cells);
            if (loops[v] != null) {
                break;
            }

            loops[v] = cells;
            valueIndex[loopCount] = v;
            loopCount++;
            if (loopCount == n + 1) {
                return cells;
            }
            cells = next(cells);
        }

        return loops[valueIndex[n % loopCount]];
    }

    private int[] next(int[] cells) {
        int[] result = new int[8];
        for (int i = 1; i < 7; i++) {
            result[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        }
        return result;
    }

    private int value(int[] cells) {
        int result = 0;
        for (int i = 1; i < 7; i++) {
            result = result * 2 + cells[i];
        }
        return result;
    }
}
