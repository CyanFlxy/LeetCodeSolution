package com.cyanflxy.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <pre>
 * Input: [1,3,5,6], 5
 * Output: 2
 * </pre>
 * Example 2:
 * <pre>
 * Input: [1,3,5,6], 2
 * Output: 1
 * </pre>
 * Example 3:
 * <pre>
 * Input: [1,3,5,6], 7
 * Output: 4
 * </pre>
 * Example 4:
 * <pre>
 * Input: [1,3,5,6], 0
 * Output: 0
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/3/3.
 */

public class _35_Search_Insert_Position {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _35_Search_Insert_Position object = new _35_Search_Insert_Position();

        System.out.println(object.searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(object.searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(object.searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
        System.out.println(object.searchInsert(new int[]{1, 3, 5, 6}, 0) == 0);
    }

    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if (result >= 0) {
            return result;
        } else {
            return -result - 1;
        }
    }
}
