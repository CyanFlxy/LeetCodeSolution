package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2021.07.29
 */
public class _209 {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;
        int low = 0;

        for (int i = 0; i < nums.length; i++) {
            int s = sum[i] + nums[i];
            sum[i + 1] = s;
            int diff = s - target;

            while (low <= i && sum[low] <= diff) {
                low++;
            }

            if (low > 0) {
                min = Math.min(min, i - low + 1);
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public int minSubArrayLen1(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int s = sum[i] + nums[i];
            sum[i + 1] = s;
            int diff = s - target;

            int l = 0;
            int h = i;
            while (l < h) {
                int m = (l + h + 1) / 2;
                if (sum[m] > diff) {
                    h = m - 1;
                } else {
                    l = m;
                }
            }
            if (sum[l] <= diff) {
                min = Math.min(min, i - l + 1);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
