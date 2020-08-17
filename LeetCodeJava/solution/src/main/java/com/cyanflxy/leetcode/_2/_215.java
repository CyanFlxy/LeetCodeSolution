package com.cyanflxy.leetcode._2;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/8/17
 */
public class _215 {

    public static void main(String... args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int result = new _215().findKthLargest(nums, 4);
        System.out.println(result);
    }

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, 0, nums.length - 1, k);
    }

    private int quickFind(int[] nums, int low, int high, int k) {
        if (low == high) {
            return nums[low];
        }

        int i = low - 1;
        int j = high + 1;
        int mid = nums[(i + j) >> 1];

        while (i < j) {
            do {
                i++;
            } while (nums[i] > mid);

            do {
                j--;
            } while (nums[j] < mid);

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        if (j - low + 1 >= k) {
            return quickFind(nums, low, j, k);
        } else {
            return quickFind(nums, j + 1, high, k - (j - low + 1));
        }

    }

}
