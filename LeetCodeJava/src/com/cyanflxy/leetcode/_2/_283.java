package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                if (left != right) {
                    nums[left++] = nums[right];
                } else {
                    left++;
                }
            }
            right++;
        }

        left++;
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }
}
