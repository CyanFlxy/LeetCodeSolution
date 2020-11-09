package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/2
 */
public class _1267 {
    public int countServers(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rowTotal = new int[m];
        int[] colTotal = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += 1;
                    rowTotal[i] += 1;
                    colTotal[j] += 1;
                }
            }
        }

        List<Integer> row1 = new ArrayList<>();
        List<Integer> col1 = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (rowTotal[i] == 1) {
                row1.add(i);
            }
        }

        for (int j = 0; j < n; j++) {
            if (colTotal[j] == 1) {
                col1.add(j);
            }
        }

        for (int i : row1) {
            for (int j : col1) {
                if (grid[i][j] == 1) {
                    result--;
                }
            }
        }

        return result;
    }
}
