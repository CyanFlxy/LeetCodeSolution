package com.cyanflxy.leetcode._5;

import java.util.Arrays;

public class _594 {
    public int findLHS(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) {
            return 0;
        }
        if (nums[0] == nums[nums.length - 1] - 1) {
            return nums.length;
        }

        int lastLen = 0;
        int lastValue = nums[0] - 2;
        int currentLen = 0;
        int currentValue = nums[0] - 2;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];

            if (v == currentValue) {
                currentLen++;
            } else {
                if (currentValue - lastValue == 1) {
                    maxLen = Math.max(maxLen, currentLen + lastLen);
                }

                lastLen = currentLen;
                lastValue = currentValue;
                currentLen = 1;
                currentValue = v;
            }
        }

        if (currentValue - lastValue == 1) {
            maxLen = Math.max(maxLen, currentLen + lastLen);
        }

        return maxLen;
    }
}
