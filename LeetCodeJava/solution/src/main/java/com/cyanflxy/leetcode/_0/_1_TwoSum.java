package com.cyanflxy.leetcode._0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.<br>
 * You may assume that each input would have exactly one solution.<br>
 * The return format had been changed to zero-based indices.
 * </p>
 * Example:
 * <pre>
 *     Given nums = [2, 7, 11, 15], target = 9,
 *
 *     Because nums[0] + nums[1] = 2 + 7 = 9,
 *     return [0, 1].
 * </pre>
 * Created by XiaYuqiang on 2016/10/12.
 */
public class _1_TwoSum {

    public static void main(String... args) {
        int[] result = new _1_TwoSum().twoSum(new int[]{0, 4, 3, 0}, 0);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        Map<Integer, Integer> numberMap = new HashMap<>();

        int number;
        int diff;

        for (int i = 0; i < len; i++) {
            number = nums[i];
            diff = target - number;

            if (numberMap.containsKey(diff)) {
                return new int[]{numberMap.get(diff), i};
            } else {
                numberMap.put(number, i);
            }
        }

        return null;
    }
}