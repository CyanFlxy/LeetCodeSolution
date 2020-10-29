package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/10/29
 */
public class _238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int val = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = val;
            val *= nums[i];
        }

        val = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= val;
            val *= nums[i];
        }

        return result;
    }


}
