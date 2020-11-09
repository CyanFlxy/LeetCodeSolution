package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _268 {
    public int missingNumber(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }

        int len = nums.length;
        int expect = (1 + len) * len / 2;
        return expect - total;
    }
}
