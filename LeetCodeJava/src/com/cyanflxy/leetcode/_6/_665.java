package com.cyanflxy.leetcode._6;

public class _665 {

    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int numi = nums[i];
                nums[i] = nums[i - 1];
                if (isSorted(nums)) {
                    return true;
                }

                nums[i] = numi;
                nums[i - 1] = numi;
                return isSorted(nums);
            }
        }

        return true;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
