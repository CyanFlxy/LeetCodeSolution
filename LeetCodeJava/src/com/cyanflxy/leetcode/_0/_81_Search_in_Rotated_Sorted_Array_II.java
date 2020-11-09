package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * <p>
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Created by cyanflxy on 2018/4/1.
 */

public class _81_Search_in_Rotated_Sorted_Array_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _81_Search_in_Rotated_Sorted_Array_II object = new _81_Search_in_Rotated_Sorted_Array_II();

        System.out.println(object.search(new int[]{3, 3, 1, 1, 1, 2, 2, 3,}, 3));
        System.out.println(object.search(new int[]{3, 1, 2, 2, 2}, 1));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int c = s + (e - s) / 2;

            if (nums[c] == target) {
                return true;
            } else if (nums[c] < nums[e]) {
                if (nums[c] < target && target <= nums[e]) {
                    s = c + 1;
                } else {
                    e = c - 1;
                }
            } else if (nums[c] > nums[e]) {

                if (nums[s] <= target && target < nums[c]) {
                    e = c - 1;
                } else {
                    s = c + 1;
                }

            } else {
                e--;
            }
        }

        return false;
    }
}
