package com.cyanflxy.leetcode._15;

/**
 * @author cyanflxy
 * @since 2020/10/9
 */
public class _1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int len = arr.length;
        int limit = (len % 2 == 0) ? (len - 1) : len;

        for (int i = 0; i < len; i++) {
            int v = arr[i];
            int count = Math.min(i + 1, len - i);
            for (int j = 1; j <= limit; j += 2) {
                int maxCount = Math.min(j, len - j + 1);
                sum += v * Math.min(count, maxCount);
            }
        }

        return sum;
    }
}
