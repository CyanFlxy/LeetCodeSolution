package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _1299 {
    public int[] replaceElements(int[] arr) {
        int max = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int t = Math.max(max, arr[i]);
            arr[i] = max;
            max = t;
        }

        return arr;
    }
}
