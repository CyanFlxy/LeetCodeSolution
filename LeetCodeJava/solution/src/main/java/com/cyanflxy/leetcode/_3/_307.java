package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/8/22
 */
public class _307 {
    class NumArray {

        private int[] nums;

        // 添加区域缓存或选取适当的数据结构(二叉树)可以加快检索速度
        public NumArray(int[] nums) {
            if (nums != null) {
                this.nums = nums;
            } else {
                this.nums = new int[0];
            }
        }

        public void update(int i, int val) {
            if (i >= 0 && i < nums.length) {
                nums[i] = val;
            }
        }

        public int sumRange(int i, int j) {
            int sum = 0;

            for (int x = i; x >= 0 && x < nums.length && x <= j; x++) {
                sum += nums[x];
            }

            return sum;
        }
    }
}
