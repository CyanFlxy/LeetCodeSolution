package com.cyanflxy.leetcode._5;

public class _540 {
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
