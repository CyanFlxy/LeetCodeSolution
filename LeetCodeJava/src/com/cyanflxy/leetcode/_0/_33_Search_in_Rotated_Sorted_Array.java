package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Created by cyanflxy on 2018/3/5.
 */

public class _33_Search_in_Rotated_Sorted_Array {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _33_Search_in_Rotated_Sorted_Array object = new _33_Search_in_Rotated_Sorted_Array();

        System.out.println(object.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7,}, 3) == 3);
        System.out.println(object.search(new int[]{4, 5, 6, 7, 0, 1, 2, 3,}, 3) == 7);
        System.out.println(object.search(new int[]{5, 6, 7, 0, 1, 2, 3, 4,}, 3) == 6);
        System.out.println(object.search(new int[]{7, 0, 1, 2, 3, 4, 5, 6,}, 3) == 4);

    }

    // 顺序依次比较，可以通过。但是本题明显不应该这样做。
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[end]) {

                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;
    }
}
