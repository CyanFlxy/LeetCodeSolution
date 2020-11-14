package com.cyanflxy.leetcode._4;

public class _413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }

        int result = 0;
        int lastDiff = A[1] - A[0];
        int len = 2;

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] == lastDiff) {
                len++;
            } else {
                if (len >= 3) {
                    int count = (len - 1) * (len - 2) / 2;
                    result += count;
                }
                len = 2;
                lastDiff = A[i + 1] - A[i];
            }
        }
        if (len >= 3) {
            int count = (len - 1) * (len - 2) / 2;
            result += count;
        }

        return result;
    }
}
