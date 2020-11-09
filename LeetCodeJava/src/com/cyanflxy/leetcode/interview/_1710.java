package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2020/9/1
 */
public class _1710 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                n = nums[i];
                count = 1;
            }
        }

        count = 0;
        for (int i : nums) {
            if (i == n) {
                count++;
            }
        }

        return (count >= nums.length / 2 + 1) ? n : -1;

    }

}
