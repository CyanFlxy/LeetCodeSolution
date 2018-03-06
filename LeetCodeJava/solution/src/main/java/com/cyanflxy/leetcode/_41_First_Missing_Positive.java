package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 * <p>
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p>
 * Created by cyanflxy on 2018/3/5.
 */

public class _41_First_Missing_Positive {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _41_First_Missing_Positive object = new _41_First_Missing_Positive();

//        System.out.println(object.firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(object.firstMissingPositive(new int[]{-1}));
//        System.out.println(object.firstMissingPositive(new int[]{1, 1}));
//        System.out.println(object.firstMissingPositive(new int[]{-1, 1000}));
//        System.out.println(object.firstMissingPositive(new int[]{1, 2, 3}));
//        System.out.println(object.firstMissingPositive(new int[]{4, 3, 2, 1,}));
        System.out.println(object.firstMissingPositive(new int[]{4, 3, 6, 4, 5, 8, 2, 1,}));
    }

    // 重要思想：利用当前数组做计算，因为缺失的数字大小不会超过数组长度(唯一的例外是等于长度加一)
    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (0 < nums[i] && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }
}
