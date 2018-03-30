package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/word-search/description/
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <pre>
 * [
 *      ['A','B','C','E'],
 *      ['S','F','C','S'],
 *      ['A','D','E','E']
 * ]
 * </pre>
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * <p>
 * Created by cyanflxy on 2018/3/30.
 */

public class _79_Word_Search {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _79_Word_Search object = new _79_Word_Search();

        System.out.println(object.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(object.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
        System.out.println(object.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null) {
            return false;
        }

        int m = board.length;
        if (m == 0 || board[0] == null) {
            return false;
        }

        int n = board[0].length;
        if (n == 0) {
            return false;
        }

        boolean[][] used = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, i, j, chars, 0, used)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, int m, int n,
                          char[] word, int i, boolean[][] used) {
        if (i >= word.length) {
            return true;
        }

        if (m < 0 || m >= board.length
                || n < 0 || n >= board[0].length
                || board[m][n] != word[i]
                || used[m][n]) {
            return false;
        }

        used[m][n] = true;

        if (check(board, m - 1, n, word, i + 1, used)) {
            return true;
        }
        if (check(board, m + 1, n, word, i + 1, used)) {
            return true;
        }
        if (check(board, m, n - 1, word, i + 1, used)) {
            return true;
        }
        if (check(board, m, n + 1, word, i + 1, used)) {
            return true;
        }

        used[m][n] = false;
        return false;
    }
}
