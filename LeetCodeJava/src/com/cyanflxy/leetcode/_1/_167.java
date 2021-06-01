package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2021.06.01
 */
public class _167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length - 1;
        while (l < h) {
            int t = target - numbers[l];
            h = find(numbers, l + 1, h, t);
            if (t == numbers[h]) {
                return new int[]{l + 1, h + 1};
            } else {
                l++;
            }
        }
        return null;
    }

    private int find(int[] nums, int l, int h, int t) {
        while (l < h) {
            int mid = (l + h + 1) / 2;
            if (nums[mid] > t) {
                h = mid - 1;
            } else if (nums[mid] < t) {
                l = mid;
            } else {
                return mid;
            }
        }
        return l;
    }
}
