package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/remove-element/description/
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <pre>
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/2/26.
 */

public class _27_Remove_Element {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _27_Remove_Element object = new _27_Remove_Element();

        System.out.println(object.removeElement(new int[]{1, 1, 2, 3, 3, 4, 5}, 2));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentIndex++] = nums[i];
            }
        }

        return currentIndex;
    }
}
