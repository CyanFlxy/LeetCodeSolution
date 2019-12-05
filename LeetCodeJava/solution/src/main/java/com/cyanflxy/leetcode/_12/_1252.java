package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/5
 */
public class _1252 {

    public int oddCells(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }

        int rowOdd = 0;
        for (int i : rows) {
            if ((i & 1) == 1) {
                rowOdd++;
            }
        }

        int colOdd = 0;
        for (int i : cols) {
            if ((i & 1) == 1) {
                colOdd++;
            }
        }

        return rowOdd * (m - colOdd) + colOdd * (n - rowOdd);
    }

}
