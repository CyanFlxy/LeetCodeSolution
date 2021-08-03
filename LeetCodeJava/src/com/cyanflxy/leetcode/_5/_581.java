package com.cyanflxy.leetcode._5;

/**
 * @author cyanflxy
 * @since 2021.08.03
 */
public class _581 {
    public int findUnsortedSubarray(int[] nums) {
        int maxLeft = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                maxLeft = i + 1;
            } else {
                break;
            }
        }

        if (maxLeft >= nums.length) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = maxLeft; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        while (maxLeft > 0 && nums[maxLeft - 1] > min) {
            maxLeft--;
        }


        int maxRight = nums.length - 2;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                maxRight = i - 1;
            } else {
                break;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = maxRight; i >= 0; i--) {
            max = Math.max(max, nums[i]);
        }
        while (maxRight < nums.length - 1 && nums[maxRight + 1] < max) {
            maxRight++;
        }

        return maxRight - maxLeft + 1;
    }


}
