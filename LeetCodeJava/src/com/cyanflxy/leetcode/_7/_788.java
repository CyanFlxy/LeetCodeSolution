package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.08
 */
public class _788 {

    public int rotatedDigits(int N) {
        int result = 0;
        for (int i = 2; i <= N; i++) {
            if (isGood(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isGood(int d) {
        boolean result = false;
        while (d > 0) {
            int x = d % 10;
            d /= 10;

            if (x == 2 || x == 5 || x == 6 || x == 9) {
                result = true;
            } else if (x == 3 || x == 4 || x == 7) {
                return false;
            }
        }

        return result;
    }
}
