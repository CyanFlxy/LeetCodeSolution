package com.cyanflxy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/description/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * <pre>
 * [
 *      [1,1,2],
 *      [1,2,1],
 *      [2,1,1]
 * ]
 * </pre>
 * Created by cyanflxy on 2018/3/7.
 */

public class _47_Permutations_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _47_Permutations_II object = new _47_Permutations_II();

//        System.out.println(object.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(object.permuteUnique(new int[]{1, 1, 2, 2}));
//        System.out.println(object.permuteUnique(new int[]{0, 0, 0, 1, 9}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }

        permuteUnique(array, 0, result);
        return result;
    }

    private void permuteUnique(Integer[] nums, int startIndex, List<List<Integer>> result) {
        if (startIndex == nums.length - 1) {
            Integer[] arr = new Integer[nums.length];
            System.arraycopy(nums, 0, arr, 0, nums.length);
            result.add(Arrays.asList(arr));
            return;
        }

        permuteUnique(nums, startIndex + 1, result);

        Integer temp = nums[startIndex];
        Set<Integer> swapped = new HashSet<>();
        swapped.add(temp);

        for (int i = startIndex; i < nums.length; i++) {
            if (swapped.contains(nums[i])) {
                continue;
            }
            swapped.add(nums[i]);

            // swap
            nums[startIndex] = nums[i];
            nums[i] = temp;

            permuteUnique(nums, startIndex + 1, result);

            // swap back
            nums[i] = nums[startIndex];
            nums[startIndex] = temp;
        }
    }

}
