package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _650 {
    public static void main(String[] args) {
        new _650().minSteps(18);
    }

    public int minSteps(int n) {
        int result = 0;
        while (n > 1) {
            int i = factorization(n);
            n /= i;
            result += i;
        }
        return result;
    }

    private int factorization(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

}
