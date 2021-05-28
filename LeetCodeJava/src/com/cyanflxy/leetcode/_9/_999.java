package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.05.28
 */
public class _999 {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int result = 0;

                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'p') {
                            result++;
                            break;
                        } else if (board[k][j] != '.') {
                            break;
                        }
                    }

                    for (int k = i + 1; k < 8; k++) {
                        if (board[k][j] == 'p') {
                            result++;
                            break;
                        } else if (board[k][j] != '.') {
                            break;
                        }
                    }

                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'p') {
                            result++;
                            break;
                        } else if (board[i][k] != '.') {
                            break;
                        }
                    }

                    for (int k = j + 1; k < 8; k++) {
                        if (board[i][k] == 'p') {
                            result++;
                            break;
                        } else if (board[i][k] != '.') {
                            break;
                        }
                    }

                    return result;
                }
            }
        }
        return 0;
    }
}
