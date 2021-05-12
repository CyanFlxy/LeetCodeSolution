package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.12
 */
public class _790 {

    public static void main(String[] args) {
        int result = new _790().numTilings(3);
        System.out.println(result);
    }

    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }

        long n_1 = 2;
        long n_2 = 1;
        long sum_n = 0;
        long result = 0;
        int mod = 10_0000_0007;

        for (int i = 3; i <= n; i++) {
            result = n_1 + n_2 + sum_n + 2;
            result %= mod;
            sum_n += n_2 * 2;
            sum_n %= mod;
            n_2 = n_1;
            n_1 = result;


        }

        return (int) result;
    }
}
