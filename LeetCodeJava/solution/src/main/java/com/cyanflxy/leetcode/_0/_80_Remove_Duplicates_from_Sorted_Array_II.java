package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * <p>
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * Created by cyanflxy on 2018/3/30.
 */

public class _80_Remove_Duplicates_from_Sorted_Array_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _80_Remove_Duplicates_from_Sorted_Array_II object = new _80_Remove_Duplicates_from_Sorted_Array_II();

        System.out.println(object.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 3}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int current = nums[0];
        int currentCount = 1;
        int index = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] == current) {
                currentCount++;
                if (currentCount <= 2) {
                    nums[index++] = current;
                }
            } else {
                current = nums[i];
                currentCount = 1;
                nums[index++] = current;
            }
        }

        return index;
    }
}
