package com.cyanflxy.leetcode._7;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.05.13
 */
public class _764 {

    public static void main(String[] args) {
        new _764().orderOfLargestPlusSign(3, new int[][]{{0, 0}});
    }

    private Set<Integer> minesSet = new HashSet<>();

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (mines.length == n * n) {
            return 0;
        }

        for (int[] m : mines) {
            minesSet.add(getHash(m));
        }

        int max = (n + 1) / 2;
        int min = 1;

        while (min < max) {
            int mid = (min + max + 1) / 2;
            if (checkPlus(mid, n)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    private boolean checkPlus(int x, int n) {
        int start = x - 1;
        int end = n - x + 1;
        int target = x * 2 - 1;

        int count;
        for (int i = start; i < end; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (minesSet.contains(getHash(i, j))) {
                    count = 0;
                    if (j >= end) {
                        break;
                    }
                } else {
                    count++;

                    if (count >= target) {
                        boolean success = true;
                        for (int k = i - x + 1; k < i + x; k++) {
                            if (minesSet.contains(getHash(k, j - x + 1))) {
                                success = false;
                                break;
                            }
                        }
                        if (success) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private int getHash(int[] m) {
        return (m[0] << 16) | m[1];
    }

    private int getHash(int x, int y) {
        return (x << 16) | y;
    }
}
