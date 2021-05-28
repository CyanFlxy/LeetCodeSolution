package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.28
 */
public class _849 {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] dist = new int[len + 1];
        dist[0] = len;

        for (int i = 1; i <= len; i++) {
            if (seats[i - 1] == 1) {
                dist[i] = 0;
            } else {
                dist[i] = dist[i - 1] + 1;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            dist[i] = Math.min(dist[i], dist[i + 1] + 1);
        }

        int result = 0;
        for (int i = 1; i <= len; i++) {
            result = Math.max(result, dist[i]);
        }
        return result;
    }
}
