package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.06.04
 */
public class _905 {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int l = 0;
        int h = len - 1;

        while (l < h) {
            while (l < len && nums[l] % 2 == 0) {
                l++;
            }
            while (h >= 0 && nums[h] % 2 == 1) {
                h--;
            }

            if (l < h) {
                int t = nums[l];
                nums[l] = nums[h];
                nums[h] = t;
            }
        }
        return nums;
    }
}
