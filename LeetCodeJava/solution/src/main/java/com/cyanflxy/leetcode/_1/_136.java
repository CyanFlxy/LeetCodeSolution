package com.cyanflxy.leetcode._1;

/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _136 {

    public static void main(String... args) {
    }

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}