package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.08.02
 */
public class _16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int ni = nums[i];

            for (int j = i + 1; j < len - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int nj = nums[j];
                for (int k = j + 1; k < len; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    int s = ni + nj + nums[k];
                    if (Math.abs(s - target) < minDiff) {
                        minDiff = Math.abs(s - target);
                        sum = s;
                    }

                }
            }
        }

        return sum;
    }
}
