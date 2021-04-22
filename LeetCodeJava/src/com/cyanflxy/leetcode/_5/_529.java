package com.cyanflxy.leetcode._5;

public class _529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        int count = mineCount(board, x, y);
        if (count > 0) {
            board[x][y] = (char) ('0' + count);
        } else {
            board[x][y] = 'B';
            dig(board, x, y);
        }

        return board;
    }

    private int mineCount(char[][] board, int x, int y) {
        int count = 0;
        if (x > 0) {
            if (y > 0) {
                if (board[x - 1][y - 1] == 'M') {
                    count++;
                }
            }

            if (board[x - 1][y] == 'M') {
                count++;
            }

            if (y < board[0].length - 1) {
                if (board[x - 1][y + 1] == 'M') {
                    count++;
                }
            }
        }

        if (y > 0) {
            if (board[x][y - 1] == 'M') {
                count++;
            }
        }

        if (board[x][y] == 'M') {
            count++;
        }

        if (y < board[0].length - 1) {
            if (board[x][y + 1] == 'M') {
                count++;
            }
        }
        if (x < board.length - 1) {
            if (y > 0) {
                if (board[x + 1][y - 1] == 'M') {
                    count++;
                }
            }

            if (board[x + 1][y] == 'M') {
                count++;
            }

            if (y < board[0].length - 1) {
                if (board[x + 1][y + 1] == 'M') {
                    count++;
                }
            }
        }

        return count;
    }

    private void dig(char[][] board, int x, int y) {
        if (x > 0) {
            if (y > 0) {
                if (board[x - 1][y - 1] == 'E') {
                    updateBoard(board, new int[]{x - 1, y - 1});
                }
            }

            if (board[x - 1][y] == 'E') {
                updateBoard(board, new int[]{x - 1, y});
            }

            if (y < board[0].length - 1) {
                if (board[x - 1][y + 1] == 'E') {
                    updateBoard(board, new int[]{x - 1, y + 1});
                }
            }
        }

        if (y > 0) {
            if (board[x][y - 1] == 'E') {
                updateBoard(board, new int[]{x, y - 1});
            }
        }

        if (board[x][y] == 'E') {
            updateBoard(board, new int[]{x, y});
        }

        if (y < board[0].length - 1) {
            if (board[x][y + 1] == 'E') {
                updateBoard(board, new int[]{x, y + 1});
            }
        }
        if (x < board.length - 1) {
            if (y > 0) {
                if (board[x + 1][y - 1] == 'E') {
                    updateBoard(board, new int[]{x + 1, y - 1});
                }
            }

            if (board[x + 1][y] == 'E') {
                updateBoard(board, new int[]{x + 1, y});
            }

            if (y < board[0].length - 1) {
                if (board[x + 1][y + 1] == 'E') {
                    updateBoard(board, new int[]{x + 1, y + 1});
                }
            }
        }
    }
}
