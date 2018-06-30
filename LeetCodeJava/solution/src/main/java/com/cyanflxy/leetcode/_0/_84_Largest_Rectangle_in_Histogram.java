package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * <p>
 * Given n non-negative integers representing the histogram's bar height
 * where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * <p>
 * Created by cyanflxy on 2018/4/9.
 */

public class _84_Largest_Rectangle_in_Histogram {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _84_Largest_Rectangle_in_Histogram object = new _84_Largest_Rectangle_in_Histogram();
        System.out.println(object.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(object.largestRectangleArea(new int[]{1, 1, 1, 1,}));
    }

    public int largestRectangleArea(int[] heights) {
        return find(heights, 0, heights.length - 1);
    }

    private int find(int[] h, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return h[left];
        }

        int minIndex = left;
        boolean sorted = true;

        for (int i = left + 1; i <= right; i++) {
            if (h[i] < h[i - 1]) {
                sorted = false;
            }
            if (h[i] < h[minIndex]) {
                minIndex = i;
            }
        }

        if (sorted) {
            int max = 0;
            for (int i = left; i <= right; i++) {
                if (h[i] * (right - i + 1) > max) max = h[i] * (right - i + 1);
            }
            return max;
        } else {
            int maxLeft = find(h, left, minIndex - 1);
            int maxRight = find(h, minIndex + 1, right);
            int crossMax = h[minIndex] * (right - left + 1);
            return Math.max(Math.max(maxLeft, maxRight), crossMax);
        }
    }

    // 时间复杂度过高
//    public int largestRectangleArea(int[] heights) {
//        if (heights == null || heights.length == 0) {
//            return 0;
//        }
//
//        int len = heights.length;
//        if (len == 1) {
//            return heights[0];
//        }
//
//        int[] maxResult = new int[len];
//        int[] lastMin = new int[len];
//        System.arraycopy(heights, 0, maxResult, 0, len);
//        System.arraycopy(heights, 0, lastMin, 0, len);
//
//        for (int i = 1; i < len; i++) {
//            if (i + 1 < len && heights[i] == heights[i + 1]) {
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                lastMin[j] = Math.min(lastMin[j], heights[i]);
//                maxResult[j] = Math.max(maxResult[j], lastMin[j] * (i - j + 1));
//            }
//        }
//
//        int max = 0;
//        for (int i = 0; i < len; i++) {
//            max = Math.max(max, maxResult[i]);
//        }
//        return max;
//    }

}
