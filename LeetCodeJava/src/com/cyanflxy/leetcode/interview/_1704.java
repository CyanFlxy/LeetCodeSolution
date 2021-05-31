package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.05.31
 */
public class _1704 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int target = (1 + len) * len / 2;
        for (int n : nums) {
            target -= n;
        }
        return target;
    }
}
