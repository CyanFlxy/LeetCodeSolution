package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:<br>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * <pre>
 * [
 *      [1, 7],
 *      [1, 2, 5],
 *      [2, 6],
 *      [1, 1, 6]
 * ]
 * </pre>
 * Created by cyanflxy on 2018/3/5.
 */

public class _40_Combination_Sum_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _40_Combination_Sum_II object = new _40_Combination_Sum_II();

        System.out.println(object.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        Integer[] helper = new Integer[target];
        checkSum(candidates, 0, helper, 0, 0, target, result);

        return result;
    }

    private void checkSum(int[] candidates, int startIndex, Integer[] helper, int helperIndex, int helperSum, int target, List<List<Integer>> result) {

        int sum;
        int checkValue = -1;

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] == checkValue) {
                continue;
            }
            checkValue = candidates[i];

            sum = helperSum + candidates[i];
            if (sum <= target) {
                helper[helperIndex] = candidates[i];

                if (sum == target) {
                    Integer[] array = new Integer[helperIndex + 1];
                    System.arraycopy(helper, 0, array, 0, helperIndex + 1);
                    result.add(Arrays.asList(array));

                } else {
                    checkSum(candidates, i + 1, helper, helperIndex + 1, sum, target, result);
                }
            }
        }

    }

}
