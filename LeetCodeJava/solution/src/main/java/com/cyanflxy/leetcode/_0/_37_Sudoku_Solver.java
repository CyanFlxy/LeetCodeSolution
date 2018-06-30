package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sudoku-solver/description/
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 * <p>
 * Created by cyanflxy on 2018/3/1.
 */

public class _37_Sudoku_Solver {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _37_Sudoku_Solver object = new _37_Sudoku_Solver();

//        char[][] board = new char[][]{
//                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
//        };
        char[][] board = new char[][]{
                {'.', '.', '.', '2', '.', '.', '.', '6', '3'},
                {'3', '.', '.', '.', '.', '5', '4', '.', '1'},
                {'.', '.', '1', '.', '.', '3', '9', '8', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '3', '8', '.', '.', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '6', '3', '.', '.', '5', '.', '.'},
                {'5', '.', '3', '7', '.', '.', '.', '.', '8'},
                {'4', '7', '.', '.', '.', '1', '.', '.', '.'}
        };

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        System.out.println();

        try {
            object.solveSudoku(board);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println("sudoku resolve " + object.resolveValue);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private int resolveValue;
    private SudokuItem[][] sudokuRow;
    private SudokuItem[][] sudokuCol;
    private SudokuItem[][] smallBlock;

    public void solveSudoku(char[][] board) {
        resolveValue = 0;
        initPossible();
        extractSmallBlock(sudokuRow);
        initSudokuBoard(board);

        int lastValue;
        do {
            lastValue = resolveValue;
            checkPossible();
        } while (lastValue != resolveValue);

        fillBoard(board);

        if (resolveValue != 81) {
            char[][] result = guess();
            if (result != null) {
                System.arraycopy(result, 0, board, 0, 9);
            }
        }

    }

    private void initPossible() {
        sudokuRow = new SudokuItem[9][9];
        sudokuCol = new SudokuItem[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuRow[i][j] = new SudokuItem(i, j);
                sudokuCol[j][i] = sudokuRow[i][j];
            }
        }
    }

    private void extractSmallBlock(SudokuItem[][] possible) {
        smallBlock = new SudokuItem[9][9];
        int index1 = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                int index2 = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        smallBlock[index1][index2++] = possible[i + m][j + n];
                    }
                }

                index1++;
            }
        }
    }

    private void initSudokuBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    setSudokuItem(i, j, ch - '1');
                }
            }
        }
    }

    private void fillBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    board[i][j] = (char) (sudokuRow[i][j].realValue + '1');
                }
            }
        }
    }

    private void setSudokuItem(int row, int col, int value) {
        SudokuItem currentItem = sudokuRow[row][col];
        if (!currentItem.setRealValue(value)) {
            return;
        }

        resolveValue++;
        int smallIndex = row / 3 * 3 + col / 3;

        for (int i = 0; i < 9; i++) {
            if (currentItem != sudokuRow[i][col]) {
                sudokuRow[i][col].deletePossible(value);
            }

            if (currentItem != sudokuRow[row][i]) {
                sudokuRow[row][i].deletePossible(value);
            }

            if (currentItem != smallBlock[smallIndex][i]) {
                smallBlock[smallIndex][i].deletePossible(value);
            }
        }

    }

    private void checkPossible() {
        for (int i = 0; i < 9; i++) {
            check1PossibleInLine(sudokuRow[i]);
            check1PossibleInLine(sudokuCol[i]);
            check1PossibleInLine(smallBlock[i]);
        }

        for (int i = 0; i < 9; i++) {
            check2PossibleInLine(sudokuRow[i]);
            check2PossibleInLine(sudokuCol[i]);
            check2PossibleInLine(smallBlock[i]);
        }
    }

    private void check1PossibleInLine(SudokuItem[] line) {
        SudokuItem possibleItem;

        for (int i = 0; i < 9; i++) {
            possibleItem = null;

            for (SudokuItem item : line) {
                if (item.realValue >= 0) {
                    if (item.realValue == i) {
                        possibleItem = null;
                        break;
                    }
                } else if (item.possibleValue[i]) {
                    if (possibleItem == null) {
                        possibleItem = item;
                    } else {
                        possibleItem = null;
                        break;
                    }
                }
            }

            if (possibleItem != null) {
                setSudokuItem(possibleItem.row, possibleItem.col, i);
            }
        }
    }

    private void check2PossibleInLine(SudokuItem[] line) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (line[i].possibleCount == 2 && line[j].possibleCount == 2) {

                    int possible1 = -1;
                    int possible2 = -1;

                    for (int k = 0; k < 9; k++) {
                        if (line[i].possibleValue[k] && line[j].possibleValue[k]) {
                            if (possible1 < 0) {
                                possible1 = k;
                            } else {
                                possible2 = k;
                            }
                        }
                    }

                    if (possible1 >= 0 && possible2 >= 0) {
                        for (int k = 0; k < 9; k++) {
                            if (k != i && k != j) {
                                line[k].deletePossible(possible1);
                                line[k].deletePossible(possible2);
                            }
                        }
                    }
                }
            }
        }
    }

    private char[][] guess() {
        _37_Sudoku_Solver object = new _37_Sudoku_Solver();
        // guess
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (sudokuRow[i][j].realValue < 0) {
                    for (int k = 0; k < 9; k++) {

                        if (sudokuRow[i][j].possibleValue[k]) {
                            char[][] board = new char[9][9];
                            fillGuessBoard(board);

                            board[i][j] = (char) (k + '1');
                            try {
                                object.solveSudoku(board);
                            } catch (Exception e) {
                                continue;
                            }

                            if (object.resolveValue == 81) {
                                return board;
                            }
                        }

                    }
                }

            }
        }

        return null;
    }


    private void fillGuessBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (sudokuRow[i][j].realValue < 0) {
                    board[i][j] = '.';
                } else {
                    board[i][j] = (char) (sudokuRow[i][j].realValue + '1');
                }
            }
        }
    }

    private class SudokuItem {
        int row;
        int col;

        int possibleCount;
        boolean[] possibleValue;

        int realValue;

        SudokuItem(int row, int col) {
            this.row = row;
            this.col = col;

            realValue = -1;
            possibleCount = 9;
            possibleValue = new boolean[9];
            Arrays.fill(possibleValue, true);
        }

        boolean setRealValue(int value) {
            if (realValue >= 0) {
                if (value != realValue) {
                    // 状态错误
                    throw new RuntimeException("solve error " + row + "," + col + ", set " + value + ", real " + realValue);
                } else {
                    return false;
                }
            }

            if (!possibleValue[value]) {
                throw new RuntimeException("solve error " + row + "," + col + ", set " + value + " not possible ");
            }

            realValue = value;
            return true;
        }

        boolean deletePossible(int value) {
            if (realValue >= 0) {
                if (realValue == value) {
                    throw new RuntimeException("solve error " + row + "," + col + " delete possible " + value + ", real value");
                }
                return false;
            }

            if (possibleValue[value]) {
                possibleValue[value] = false;
                possibleCount--;
                if (possibleCount == 1) {
                    for (int i = 0; i < 9; i++) {
                        if (possibleValue[i]) {
                            setSudokuItem(row, col, i);
                            break;
                        }
                    }
                } else if (possibleCount == 0) {
                    throw new RuntimeException("solve error " + row + "," + col + " delete possible " + value + ", possible none");
                }
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (realValue >= 0) {
                sb.append(realValue + 1);
            } else {
                for (int i = 0; i < 9; i++) {
                    if (possibleValue[i]) {
                        sb.append(i + 1).append(";");
                    }
                }

            }
            return sb.toString();
        }
    }
}
