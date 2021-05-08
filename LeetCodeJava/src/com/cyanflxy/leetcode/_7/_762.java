package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.08
 */
public class _762 {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            int digit = Integer.bitCount(i);
            if (digit == 2 || digit == 3 || digit == 5 || digit == 7
                    || digit == 11 || digit == 13 || digit == 17 || digit == 19) {
                result++;
            }
        }
        return result;
    }
}
