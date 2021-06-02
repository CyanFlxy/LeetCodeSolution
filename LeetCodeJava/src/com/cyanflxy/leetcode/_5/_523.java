package com.cyanflxy.leetcode._5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.06.02
 */
public class _523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        sums[1] = nums[0];

        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 2; i <= len; i++) {
            int sum = sums[i - 1] + nums[i - 1];
            int mode = sum % k;

            if (set.contains(mode)) {
                return true;
            }

            int last = sums[i - 1] % k;
            set.add(last);
            sums[i] = sum;
        }

        return false;
    }
}
