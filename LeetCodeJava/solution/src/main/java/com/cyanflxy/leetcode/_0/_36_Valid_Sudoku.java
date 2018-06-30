package com.cyanflxy.leetcode._0;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 * <p>
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules(http://sudoku.com.au/TheRules.aspx).
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * <p>
 * Created by cyanflxy on 2018/2/28.
 */

public class _36_Valid_Sudoku {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _36_Valid_Sudoku object = new _36_Valid_Sudoku();
        System.out.println(object.isValidSudoku(new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '1', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }

    // Set数据结构限制了速度，使用boolean数组会更快。
    public boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<>();
        char ch;

        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                ch = board[i][j];
                if (ch != '.') {
                    if (set.contains(ch)) {
                        return false;
                    } else {
                        set.add(ch);
                    }
                }
            }

            set.clear();
            for (int j = 0; j < 9; j++) {
                ch = board[j][i];
                if (ch != '.') {
                    if (set.contains(ch)) {
                        return false;
                    } else {
                        set.add(ch);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                set.clear();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        ch = board[i + m][j + n];
                        if (ch != '.') {
                            if (set.contains(ch)) {
                                return false;
                            } else {
                                set.add(ch);
                            }
                        }
                    }
                }

            }
        }

        return true;
    }
}
