package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.06
 */
public class _704 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int n = nums[mid];
            if (n == target) {
                return mid;
            } else if (target < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
