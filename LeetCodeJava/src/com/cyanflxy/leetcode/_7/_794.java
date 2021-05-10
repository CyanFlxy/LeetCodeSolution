package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.10
 */
public class _794 {
    public boolean validTicTacToe(String[] board) {
        int x = 0;
        int o = 0;
        for (String str : board) {
            for (int i = 0; i < 3; i++) {
                char ch = str.charAt(i);
                if (ch == 'O') {
                    o++;
                } else if (ch == 'X') {
                    x++;
                }
            }
        }

        if (!(x == o || x - o == 1)) {
            return false;
        }

        if (o < 3) {
            return true;
        }

        boolean xWin = isWin(board, 'X');
        if (xWin && x == o) {
            return false;
        }
        boolean oWin = isWin(board, 'O');
        if (oWin && x > o) {
            return false;
        }

        return !(xWin && oWin);
    }

    private boolean isWin(String[] board, char ch) {
        for (String str : board) {
            if (str.charAt(0) == ch && str.charAt(1) == ch && str.charAt(2) == ch) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }

        if (board[1].charAt(1) == ch) {
            if (board[0].charAt(0) == ch && board[2].charAt(2) == ch) {
                return true;
            }

            if (board[2].charAt(0) == ch && board[0].charAt(2) == ch) {
                return true;
            }
        }

        return false;
    }
}
