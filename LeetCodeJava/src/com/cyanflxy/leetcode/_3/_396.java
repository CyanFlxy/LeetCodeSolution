package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/10/27
 */
public class _396 {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        int v0 = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            v0 += i * A[i];
            sum += A[i];
        }

        int maxV = v0;
        int vi;

        for (int i = 1; i < len; i++) {
            vi = v0 + sum - len * A[len - i];
            maxV = vi > maxV ? vi : maxV;
            v0 = vi;
        }

        return maxV;

    }
}
