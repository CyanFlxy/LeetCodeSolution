package com.cyanflxy.leetcode._4;

import java.util.ArrayList;
import java.util.List;

public class _417 {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacificResult = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            setResult(matrix, pacificResult, 0, j);
        }
        for (int i = 1; i < m; i++) {
            setResult(matrix, pacificResult, i, 0);
        }

        boolean[][] atlanticResult = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            setResult(matrix, atlanticResult, m - 1, j);
        }
        for (int i = m - 2; i >= 0; i--) {
            setResult(matrix, atlanticResult, i, n - 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificResult[i][j] && atlanticResult[i][j]) {
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    result.add(a);
                }
            }
        }

        return result;
    }

    private void setResult(int[][] matrix, boolean[][] result, int i, int j) {
        if (result[i][j]) {
            return;
        }
        result[i][j] = true;

        int cur = matrix[i][j];
        if (i > 0 && matrix[i - 1][j] >= cur) {
            setResult(matrix, result, i - 1, j);
        }

        if (j > 0 && matrix[i][j - 1] >= cur) {
            setResult(matrix, result, i, j - 1);
        }

        if (i < matrix.length - 1 && matrix[i + 1][j] >= cur) {
            setResult(matrix, result, i + 1, j);
        }

        if (j < matrix[0].length - 1 && matrix[i][j + 1] >= cur) {
            setResult(matrix, result, i, j + 1);
        }
    }
}
