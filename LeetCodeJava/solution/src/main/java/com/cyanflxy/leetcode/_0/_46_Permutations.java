package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * <pre>
 * [
 *      [1,2,3],
 *      [1,3,2],
 *      [2,1,3],
 *      [2,3,1],
 *      [3,1,2],
 *      [3,2,1]
 * ]
 * </pre>
 * Created by cyanflxy on 2018/3/7.
 */

public class _46_Permutations {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _46_Permutations object = new _46_Permutations();

//        System.out.println(object.permute(new int[]{2, 3, 1, 1, 4}));//true
//        System.out.println(object.permute(new int[]{3, 2, 1, 0, 4}));//false
//        System.out.println(object.permute(new int[]{1, 2}));//true
//        System.out.println(object.permute(new int[]{4, 3, 2, 1, 0, 0}));//false
        System.out.println(object.permute(new int[]{1, 2, 3}));//true
        System.out.println(object.permute(new int[]{0, 1}));//true
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }

        permute(array, 0, result);
        return result;
    }

    private void permute(Integer[] nums, int startIndex, List<List<Integer>> result) {
        if (startIndex == nums.length - 1) {
            Integer[] arr = new Integer[nums.length];
            System.arraycopy(nums, 0, arr, 0, nums.length);
            result.add(Arrays.asList(arr));
            return;
        }

        permute(nums, startIndex + 1, result);

        Integer temp = nums[startIndex];
        for (int i = startIndex + 1; i < nums.length; i++) {
            // swap
            nums[startIndex] = nums[i];
            nums[i] = temp;

            permute(nums, startIndex + 1, result);

            // swap back
            nums[i] = nums[startIndex];
            nums[startIndex] = temp;
        }
    }

}
