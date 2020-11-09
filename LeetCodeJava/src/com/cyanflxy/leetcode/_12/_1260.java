package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2019/12/4
 */
public class _1260 {

    public static void main(String... args) {
//        new _1260().shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}}, 23);
        new _1260().shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9);
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        int index = total - k % total;
        int x = index / m;
        int y = index % m;
        if (x == n) {
            x = 0;
        }

        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                cur.add(grid[x][y]);

                y++;
                if (y == m) {
                    y = 0;
                    x++;
                    if (x == n) {
                        x = 0;
                    }
                }
            }
            result.add(cur);
        }

        return result;
    }
}
