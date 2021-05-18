package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _852 {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int i = 1;

        for (; i < len - 1; i++) {
            if (arr[i] < arr[i - 1]) {
                break;
            }
        }

        return i - 1;

    }
}
