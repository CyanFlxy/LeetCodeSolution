package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.07.12
 */
public class _930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 1;

        int result = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;

            if (sum >= goal) {
                result += sums[sum - goal];
            }
            sums[sum]++;
        }
        return result;
    }
}
