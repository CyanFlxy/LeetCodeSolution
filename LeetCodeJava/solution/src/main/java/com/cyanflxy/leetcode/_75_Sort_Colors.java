package com.cyanflxy.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/description/
 * <p>
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * <p>
 * Could you come up with an one-pass algorithm using only constant space?
 * <p>
 * Created by cyanflxy on 2018/3/26.
 */

public class _75_Sort_Colors {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _75_Sort_Colors object = new _75_Sort_Colors();

        int[] arr = new int[]{1, 2, 0, 1, 2, 0};
        object.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int[] counts = new int[3];
        for (int i : nums) {
            counts[i]++;
        }

        Arrays.fill(nums, 0, counts[0], 0);
        Arrays.fill(nums, counts[0], counts[1] + counts[0], 1);
        Arrays.fill(nums, nums.length - counts[2], nums.length, 2);
    }
}
