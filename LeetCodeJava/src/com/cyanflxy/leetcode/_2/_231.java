package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        // 2的幂的二进制特征
        // ((n - 1) & n) == 0

        while ((n & 1) == 0) {
            n >>= 1;
        }

        return n == 1;
    }
}
