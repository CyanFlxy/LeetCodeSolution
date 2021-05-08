package com.cyanflxy.leetcode._14;

/**
 * @author cyanflxy
 * @since 2021.05.09
 */
public class _1482 {

    public static void main(String[] args) {
        new _1482().minDays(new int[]{}, 3, 1);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int n : bloomDay) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        if (bloomDay.length == m * k) {
            return max;
        }

        while (min < max) {
            int mid = (min + max) / 2;
            if (check(bloomDay, m, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean check(int[] bloomDay, int m, int k, int day) {
        int mc = 0;
        int kc = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                kc++;
                if (kc == k) {
                    mc++;
                    if (mc == m) {
                        return true;
                    }
                    kc = 0;
                }
            } else {
                if (i + k * (m - mc) > bloomDay.length) {
                    return false;
                }
                kc = 0;
            }
        }
        return false;
    }
}
