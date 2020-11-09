package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * <p>
 * 3,2,1 → 1,2,3
 * <p>
 * 1,1,5 → 1,5,1
 * <p>
 * Created by cyanflxy on 2018/3/2.
 */

public class _31_Next_Permutation {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _31_Next_Permutation object = new _31_Next_Permutation();

//        object.test(new int[]{1});
//        object.test(new int[]{1, 3});
//        object.test(new int[]{3, 1});
//        object.test(new int[]{1, 3, 2});// 213
//        object.test(new int[]{3, 2, 1});
//        object.test(new int[]{3, 3, 3, 3});
        object.test(new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1});// [2,3,1,2,2,2,4,5,7]
        object.test(new int[]{2, 2, 3, 2, 2, 1});
    }

    private void test(int[] nums) {
        System.out.println("before: " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("after: " + Arrays.toString(nums));
        System.out.println();
    }

    // 加法计算太多，使用i，j代替要交换的首尾位置，并在循环中令二者加/减
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }

        int len = nums.length;
        if (len <= 1) {
            return;
        }

        int downIndex = -1;

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                downIndex = i;
                break;
            }
        }

        if (downIndex < 0) {
            if (nums[0] != nums[len - 1]) {
                // reverse array
                int temp;
                for (int i = 0; i < len / 2; i++) {
                    temp = nums[i];
                    nums[i] = nums[len - i - 1];
                    nums[len - i - 1] = temp;
                }
            }
        } else {

            int start = downIndex + 1;
            int temp;
            int tempIndex;
            for (int i = start; i < start + (len - start) / 2; i++) {
                temp = nums[i];
                tempIndex = start + len - i - 1;
                nums[i] = nums[tempIndex];
                nums[tempIndex] = temp;
            }

            int currentValue = nums[downIndex];
            int position = Arrays.binarySearch(nums, start, len, currentValue);
            if (position >= 0) {
                while (nums[position] == currentValue) {
                    position++;
                }
            } else {
                position = -position - 1;
            }

            nums[downIndex] = nums[position];
            nums[position] = currentValue;
        }
    }
}
