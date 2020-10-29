package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/10/29
 */
public class _289 {

    // 0, 1, -1(0->1),2(1->0)
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int c = getOneCount(board, i, j);
                if (board[i][j] == 0) {
                    if (c == 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (c != 2 && c != 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }

    }

    private int getOneCount(int[][] board, int x, int y) {
        int count = 0;
        if (x > 0) {
            if (y > 0 && board[x - 1][y - 1] > 0) {
                count++;
            }
            if (board[x - 1][y] > 0) {
                count++;
            }
            if (y < board[x - 1].length - 1 && board[x - 1][y + 1] > 0) {
                count++;
            }
        }

        if (x < board.length - 1) {
            if (y > 0 && board[x + 1][y - 1] > 0) {
                count++;
            }
            if (board[x + 1][y] > 0) {
                count++;
            }
            if (y < board[x + 1].length - 1 && board[x + 1][y + 1] > 0) {
                count++;
            }
        }

        if (y > 0 && board[x][y - 1] > 0) {
            count++;
        }
        if (y < board[x].length - 1 && board[x][y + 1] > 0) {
            count++;
        }

        return count;
    }
}
