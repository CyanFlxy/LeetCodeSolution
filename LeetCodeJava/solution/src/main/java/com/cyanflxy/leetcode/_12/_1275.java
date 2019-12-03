package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/3
 */
public class _1275 {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        int player = 1;
        for (int[] move : moves) {
            int x = move[0];
            int y = move[1];
            board[x][y] = player;
            if (isWin(board, x, y)) {
                return player == 1 ? "A" : "B";
            }

            player = 3 - player;
        }

        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private boolean isWin(int[][] board, int x, int y) {
        int cur = board[x][y];

        // 同一行
        if (board[x][0] == cur && board[x][1] == cur && board[x][2] == cur) {
            return true;
        }

        // 同一列
        if (board[0][y] == cur && board[1][y] == cur && board[2][y] == cur) {
            return true;
        }

        // 对角线 左上-右下
        if (x == y) {
            if (board[0][0] == cur && board[1][1] == cur && board[2][2] == cur) {
                return true;
            }
        }

        // 对角线 左下-右上
        if (x + y == 2) {
            if (board[0][2] == cur && board[1][1] == cur && board[2][0] == cur) {
                return true;
            }
        }

        return false;
    }
}
