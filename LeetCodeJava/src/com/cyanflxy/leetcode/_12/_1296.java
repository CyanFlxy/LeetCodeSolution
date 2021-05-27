package com.cyanflxy.leetcode._12;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.28
 */
public class _1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int x = nums[i] + 1;
            int end = x + k - 2;
            nums[i] = 0;

            int j = i + 1;
            while (x < end && j < nums.length) {
                if (x == nums[j]) {
                    nums[j] = 0;
                    x++;
                }
                j++;
            }
            if (x != end + 1) {
                return false;
            }
        }

        return true;

    }
}
