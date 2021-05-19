package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.19
 */
public class _836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        if (rec2[0] < rec1[2] && rec2[2] > rec1[0]) {
            if (rec2[1] < rec1[3] && rec2[3] > rec1[1]) {
                return true;
            }
        }
        return false;
    }
}
