package com.cyanflxy.leetcode._1;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _130 {

    public static void main(String... args) {
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }

        int n = board.length;
        int m = board[0].length;

        char[][] fork = new char[n][m];

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                copyBord(board, fork, i, 0);
            }

            if (board[i][m - 1] == 'O') {
                copyBord(board, fork, i, m - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                copyBord(board, fork, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                copyBord(board, fork, n - 1, i);
            }
        }


        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && fork[i][j] != 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void copyBord(char[][] src, char[][] fork, int i, int j) {
        if (fork[i][j] == 'O') {
            return;
        }
        fork[i][j] = 'O';

        if (i > 0 && src[i - 1][j] == 'O') {
            copyBord(src, fork, i - 1, j);
        }

        if (i < src.length - 1 && src[i + 1][j] == 'O') {
            copyBord(src, fork, i + 1, j);
        }

        if (j > 0 && src[i][j - 1] == 'O') {
            copyBord(src, fork, i, j - 1);
        }

        if (j < src[0].length - 1 && src[i][j + 1] == 'O') {
            copyBord(src, fork, i, j + 1);

        }
    }

//    以下是更快的方法
//    public void solve(char[][] board) {
//        if (board == null || board.length <= 2 || board[0].length <= 2) {
//            return;
//        }
//
//        int n = board.length;
//        int m = board[0].length;
//
//        for (int i = 0; i < n; i++) {
//            if (board[i][0] == 'O') {
//                check(board, i, 0);
//            }
//            if (board[i][m - 1] == 'O') {
//                check(board, i, m - 1);
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            if (board[0][i] == 'O') {
//                check(board, 0, i);
//            }
//            if (board[n - 1][i] == 'O') {
//                check(board, n - 1, i);
//            }
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                } else if (board[i][j] == '-') {
//                    board[i][j] = 'O';
//                }
//            }
//        }
//    }
//
//    private void check(char[][] src, int i, int j) {
//        if (i < 0 || i >= src.length || j < 0 || j >= src[0].length || src[i][j] != 'O') {
//            return;
//        }
//
//        src[i][j] = '-';
//
//        check(src, i - 1, j);
//        check(src, i + 1, j);
//        check(src, i, j - 1);
//        check(src, i, j + 1);
//    }

//    以下是正确但是超级慢的方法
//    public void solve(char[][] board) {
//        if (board == null || board.length <= 2 || board[0].length <= 2) {
//            return;
//        }
//
//        Set<Integer> live = new HashSet<>();
//        Set<Integer> dead = new HashSet<>();
//        Set<Integer> doing = new HashSet<>();
//
//        int n = board.length;
//        int m = board[0].length;
//
//        for (int i = 0; i < n; i++) {
//            if (board[i][0] == 'O') {
//                live.add(value(i, 0));
//            }
//
//            if (board[i][m - 1] == 'O') {
//                live.add(value(i, m - 1));
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            if (board[0][i] == 'O') {
//                live.add(value(0, i));
//            }
//            if (board[n - 1][i] == 'O') {
//                live.add(value(n - 1, i));
//            }
//        }
//
//        for (int i = 1; i < n - 1; i++) {
//            for (int j = 1; j < m - 1; j++) {
//                if (board[i][j] == 'O') {
//                    checkLive(board, i, j, live, dead, doing);
//                    dead.addAll(doing);
//                    doing.clear();
//                }
//            }
//        }
//
//        for (Integer v : dead) {
//            board[n(v)][m(v)] = 'X';
//        }
//    }
//
//    private void checkLive(char[][] board, int i, int j,
//                           Set<Integer> live, Set<Integer> dead, Set<Integer> doing) {
//        Integer v = value(i, j);
//
//        if (live.contains(v)) {
//            live.addAll(doing);
//            doing.clear();
//            return;
//        }
//
//        if (dead.contains(v) || doing.contains(v)) {
//            return;
//        }
//
//        doing.add(v);
//        if (board[i - 1][j] == 'O') {
//            checkLive(board, i - 1, j, live, dead, doing);
//        }
//
//        if (board[i + 1][j] == 'O') {
//            checkLive(board, i + 1, j, live, dead, doing);
//        }
//        if (board[i][j - 1] == 'O') {
//            checkLive(board, i, j - 1, live, dead, doing);
//        }
//        if (board[i][j + 1] == 'O') {
//            checkLive(board, i, j + 1, live, dead, doing);
//        }
//
//    }
//
//    private Integer value(int n, int m) {
//        return n << 16 | m;
//    }
//
//    private int n(Integer value) {
//        return value >> 16;
//    }
//
//    private int m(Integer value) {
//        return value & 0xFFFF;
//    }
}