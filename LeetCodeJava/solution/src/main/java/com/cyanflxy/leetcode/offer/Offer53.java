package com.cyanflxy.leetcode.offer;

/**
 * @author cyanflxy
 * @since 2020/10/20
 */
public class Offer53 {
    public int missingNumber(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        int expect = (nums.length + 1) * nums.length / 2;

        return expect - sum;
    }
}
