package com.cyanflxy.leetcode._5;

public class _547 {

    public static void main(String[] args) {
        int result = new _547().findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}});
        System.out.println(result);
    }

    int n;
    boolean[] counted;

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        n = isConnected.length;
        counted = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!counted[i]) {
                countLine(isConnected, i);
                count++;
            }
        }

        return count;
    }

    private void countLine(int[][] isConnected, int line) {
        counted[line] = true;
        for (int j = line; j < n; j++) {
            if (isConnected[line][j] == 1) {
                if (!counted[j]) {
                    countLine(isConnected, j);
                }
            }
        }
    }
}
