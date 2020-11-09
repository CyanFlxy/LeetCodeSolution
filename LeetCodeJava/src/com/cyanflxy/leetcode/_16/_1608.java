package com.cyanflxy.leetcode._16;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int result = nums.length;

        for (int n : nums) {
            if (n >= result) {
                return result;
            }
            result--;
            if (result <= n) {
                return -1;
            }
        }
        return -1;
    }
}
