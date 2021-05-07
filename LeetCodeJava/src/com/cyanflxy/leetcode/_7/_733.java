package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.07
 */
public class _733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        if (target != newColor) {
            fill(image, newColor, target, sr, sc);
        }
        return image;
    }

    private void fill(int[][] image, int newColor, int srcColor, int r, int c) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        if (image[r][c] != srcColor) {
            return;
        }

        image[r][c] = newColor;
        fill(image, newColor, srcColor, r + 1, c);
        fill(image, newColor, srcColor, r - 1, c);
        fill(image, newColor, srcColor, r, c + 1);
        fill(image, newColor, srcColor, r, c - 1);
    }
}
