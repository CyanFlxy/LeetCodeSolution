package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _985 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evens = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                evens += n;
            }
        }

        int[] result = new int[queries.length];
        int i = 0;

        for (int[] q : queries) {
            int val = q[0];
            int index = q[1];
            int old = nums[index];
            int newv = old + val;

            if (old % 2 == 0) {
                evens -= old;
            }
            nums[index] = newv;
            if (newv % 2 == 0) {
                evens += newv;
            }

            result[i++] = evens;
        }
        return result;
    }
}
