package com.cyanflxy.leetcode._5;

public class _503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] stack = new int[nums.length];
        int[] result = new int[nums.length];
        int si = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (si > 0 && nums[stack[si - 1]] < n) {
                si--;
                result[stack[si]] = n;
            }
            stack[si++] = i;
        }

        for (int i = 0; i < nums.length && si > 0 && i < stack[si - 1]; i++) {
            int n = nums[i];
            while (si > 0 && nums[stack[si - 1]] < n) {
                si--;
                result[stack[si]] = n;
            }
        }

        while (si > 0) {
            si--;
            result[stack[si]] = -1;
        }

        return result;
    }
}
