package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2021.07.29
 */
public class _223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int area1 = 0;
        if (ax1 < ax2 && ay1 < ay2) {
            area1 = (ax2 - ax1) * (ay2 - ay1);
        }

        int area2 = 0;
        if (bx1 < bx2 && by1 < by2) {
            area2 = (bx2 - bx1) * (by2 - by1);
        }

        int x1 = Math.max(ax1, bx1);
        int y1 = Math.max(ay1, by1);
        int x2 = Math.min(ax2, bx2);
        int y2 = Math.min(ay2, by2);

        if (x1 >= x2 || y1 >= y2) {
            return area1 + area2;
        } else {
            return area1 + area2 - (x2 - x1) * (y2 - y1);
        }
    }
}
