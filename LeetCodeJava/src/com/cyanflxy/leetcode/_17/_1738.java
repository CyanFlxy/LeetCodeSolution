package com.cyanflxy.leetcode._17;

import java.util.PriorityQueue;

/**
 * @author cyanflxy
 * @since 2021.05.19
 */
public class _1738 {

    public static void main(String[] args) {
        new _1738().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] xor = new int[row][col];

        for (int r = 0; r < row; r++) {
            if (r > 0) {
                xor[r][0] = matrix[r][0] ^ xor[r - 1][0];
            } else {
                xor[r][0] = matrix[r][0];
            }
            queue.offer(xor[r][0]);
            if (queue.size() > k) {
                queue.poll();
            }

            int currentLine = matrix[r][0];
            for (int c = 1; c < col; c++) {
                currentLine ^= matrix[r][c];

                if (r > 0) {
                    xor[r][c] = currentLine ^ xor[r - 1][c];
                } else {
                    xor[r][c] = currentLine;
                }
                queue.offer(xor[r][c]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        return queue.poll();

    }
}
