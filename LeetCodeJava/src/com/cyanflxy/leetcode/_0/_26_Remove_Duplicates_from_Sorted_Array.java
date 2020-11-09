package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * <p>
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example:
 * <pre>
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * </pre>
 * Created by cyanflxy on 2018/2/26.
 */

public class _26_Remove_Duplicates_from_Sorted_Array {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _26_Remove_Duplicates_from_Sorted_Array object = new _26_Remove_Duplicates_from_Sorted_Array();

        System.out.println(object.removeDuplicates(new int[]{1, 1, 2, 3, 3, 4, 5}));
    }

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentValue = nums[0];
        int currentIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != currentValue) {
                currentValue = nums[i];
                nums[currentIndex++] = currentValue;
            }
        }

        return currentIndex;
    }
}
