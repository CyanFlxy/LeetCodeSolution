package com.cyanflxy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:<br>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * <pre>
 * [
 *      [7],
 *      [2, 2, 3]
 * ]
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/3/5.
 */

public class _39_Combination_Sum {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _39_Combination_Sum object = new _39_Combination_Sum();

        System.out.println(object.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        int[] helper = new int[target];
        checkSum(candidates, 0, helper, 0, 0, target, result);

        return result;
    }

    private void checkSum(int[] candidates, int startIndex, int[] helper, int helperIndex, int helperSum, int target, List<List<Integer>> result) {

        int sum;
        for (int i = startIndex; i < candidates.length; i++) {
            sum = helperSum + candidates[i];
            if (sum <= target) {
                helper[helperIndex] = candidates[i];

                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j <= helperIndex; j++) {
                        list.add(helper[j]);
                    }
                    result.add(list);

                } else {
                    checkSum(candidates, i, helper, helperIndex + 1, sum, target, result);
                }
            }
        }

    }

}
