package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 1;

        int[] index = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int last = result[i - 1];
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                int next = result[index[j]] * primes[j];
                if (next > last && next < min) {
                    min = next;
                }
            }

            result[i] = min;

            for (int j = 0; j < primes.length; j++) {
                int next = result[index[j]] * primes[j];
                if (next <= min) {
                    index[j]++;
                }
            }
        }

        return result[n - 1];
    }
}
