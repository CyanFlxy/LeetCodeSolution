package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.12
 */
public class _789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int tx = target[0];
        int ty = target[1];
        int step = Math.abs(tx) + Math.abs(ty);

        for (int[] ghost : ghosts) {
            int distance = Math.abs(tx - ghost[0]) + Math.abs(ty - ghost[1]);
            if (distance <= step) {
                return false;
            }
        }
        return true;
    }
}
