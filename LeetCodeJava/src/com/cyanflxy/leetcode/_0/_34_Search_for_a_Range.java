package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-for-a-range/description/
 * <p>
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * Created by cyanflxy on 2018/3/5.
 */

public class _34_Search_for_a_Range {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _34_Search_for_a_Range object = new _34_Search_for_a_Range();

        System.out.println(Arrays.toString(object.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(object.searchRange(new int[]{5, 7, 7, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0
                || target < nums[0]
                || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;

        while (nums[start] < nums[end]) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;

            } else if (nums[mid] < target) {
                start = mid + 1;

            } else {

                int start2 = mid;
                while (nums[start] < target) {
                    int m2 = start + (start2 - start) / 2;

                    if (nums[m2] == target) {
                        if (nums[m2 - 1] == target) {
                            start2 = m2 - 1;
                        } else {
                            start = m2;
                            break;
                        }
                    } else {
                        start = m2 + 1;
                    }
                }

                int end1 = mid;
                while (nums[end] > target) {
                    int m3 = end1 + (end - end1) / 2;

                    if (nums[m3] == target) {
                        if (nums[m3 + 1] == target) {
                            end1 = m3 + 1;
                        } else {
                            end = m3;
                            break;
                        }
                    } else {
                        end = m3 - 1;
                    }
                }

            }
        }

        if (nums[start] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{start, end};
        }
    }
}
