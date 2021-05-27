package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2021.05.28
 */
public class _477 {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return result;
    }
}
