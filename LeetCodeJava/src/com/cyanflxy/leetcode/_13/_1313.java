package com.cyanflxy.leetcode._13;

/**
 * @author cyanflxy
 * @since 2020/10/21
 */
public class _1313 {
    public int[] decompressRLElist(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                int v = nums[i + 1];
                result[index++] = v;
            }
        }

        return result;

    }
}
