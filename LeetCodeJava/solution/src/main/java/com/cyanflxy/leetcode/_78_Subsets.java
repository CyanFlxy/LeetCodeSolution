package com.cyanflxy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <pre>
 * [
 *      [3],
 *      [1],
 *      [2],
 *      [1,2,3],
 *      [1,3],
 *      [2,3],
 *      [1,2],
 *      []
 * ]
 * </pre>
 * Created by cyanflxy on 2018/3/29.
 */

public class _78_Subsets {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _78_Subsets object = new _78_Subsets();

        System.out.println(object.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(Collections.emptyList());
            return result;
        }

        int len = nums.length;
        int count = (int) Math.pow(2, len);

        for (int i = 0; i < count; i++) {

            int t = i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0, p = 1; j < len && t != 0; j++, p <<= 1) {
                if ((t & p) != 0) {
                    list.add(nums[j]);
                    t ^= p;
                }
            }
            result.add(list);
        }

        return result;
    }
}
