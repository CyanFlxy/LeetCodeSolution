package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/9/4
 */
public class _204 {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];

        int i = 2;
        int count = 0;
        for (; i * i < n; i++) {
            if (!arr[i]) {
                for (int j = i * i; j < n; j += i) {
                    arr[j] = true;
                }
                count++;
            }
        }

        for (; i < n; i++) {
            if (!arr[i]) {
                count++;
            }
        }

        return count;
    }
}
