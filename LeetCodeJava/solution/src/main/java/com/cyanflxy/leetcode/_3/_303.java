package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _303 {
    class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = nums[i - 1] + sums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }

    }

}
