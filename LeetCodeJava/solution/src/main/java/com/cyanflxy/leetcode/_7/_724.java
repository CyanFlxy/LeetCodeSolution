package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2020/9/11
 */
public class _724 {

    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int total = 0;
        for (int n : nums) {
            total += n;
        }

        int half = 0;
        for (int i = 0; i < nums.length; i++) {
            if (half * 2 + nums[i] == total) {
                return i;
            }
            half += nums[i];
        }

        return -1;
    }

}
