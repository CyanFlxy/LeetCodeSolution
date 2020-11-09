package com.cyanflxy.leetcode._5;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }
}
