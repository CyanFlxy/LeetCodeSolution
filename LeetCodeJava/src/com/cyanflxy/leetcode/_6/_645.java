package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _645 {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int i = 0;
        int dup = 0;
        int wrong = 0;

        while (i < len) {
            while (i + 1 != nums[i]) {
                int t = nums[i];
                if (nums[t - 1] != t) {
                    nums[i] = nums[t - 1];
                    nums[t - 1] = t;
                } else {
                    dup = t;
                    wrong = i + 1;
                    break;
                }
            }
            i++;
        }

        return new int[]{dup, wrong};
    }
}
