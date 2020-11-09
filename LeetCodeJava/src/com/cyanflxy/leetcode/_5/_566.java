package com.cyanflxy.leetcode._5;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length;
        int oc = nums[0].length;
        if (or * oc != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int index = 0;

        for (int[] num : nums) {
            for (int v : num) {
                result[index / c][index % c] = v;
                index++;
            }
        }

        return result;
    }
}
