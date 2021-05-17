package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.17
 */
public class _896 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        boolean haveUp = false;
        boolean haveDown = false;
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                if (haveDown) {
                    return false;
                }
                haveUp = true;
            } else if (nums[i] < last) {
                if (haveUp) {
                    return false;
                }
                haveDown = true;
            }
            last = nums[i];
        }


        return true;
    }
}
