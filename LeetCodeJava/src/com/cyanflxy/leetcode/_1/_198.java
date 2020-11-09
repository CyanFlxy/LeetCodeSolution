package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2020/8/11
 */
public class _198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }

        return nums[nums.length - 1];
    }
}
