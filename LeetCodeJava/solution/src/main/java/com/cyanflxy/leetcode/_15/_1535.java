package com.cyanflxy.leetcode._15;

/**
 * @author cyanflxy
 * @since 2020/9/1
 */
public class _1535 {

    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        int round = 0;
        int len = arr.length;

        for (int i = 1; i < len && round < k; i++) {
            if (max > arr[i]) {
                round++;
            } else {
                max = arr[i];
                round = 1;
            }
        }

        return max;
    }

}
