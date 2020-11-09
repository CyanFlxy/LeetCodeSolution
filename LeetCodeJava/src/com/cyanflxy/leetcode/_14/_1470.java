package com.cyanflxy.leetcode._14;

/**
 * @author cyanflxy
 * @since 2020/9/29
 */
public class _1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];

        int i = 0;
        int j = n;
        int index = 0;

        while (i < n) {
            result[index++] = nums[i++];
            result[index++] = nums[j++];
        }

        return result;
    }
}
