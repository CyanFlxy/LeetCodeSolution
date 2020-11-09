package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <pre>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * </pre>
 * Created by cyanflxy on 2018/5/21.
 */

public class _90_Subsets_II {


    public static void main(String... args) {
        test();
    }

    private static void test() {
        _90_Subsets_II object = new _90_Subsets_II();

        System.out.println(object.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        fillResult(result, nums, 0, new ArrayList<>());

        return result;
    }

    private void fillResult(List<List<Integer>> result, int[] src,
                            int index, List<Integer> subset) {

        if (src.length == index) {
            result.add(subset);
            return;
        }

        List<Integer> subset2 = new ArrayList<>(subset);
        subset2.add(src[index]);
        fillResult(result, src, index + 1, subset2);

        while (index + 1 < src.length && src[index] == src[index + 1]) {
            index++;
        }
        fillResult(result, src, index + 1, subset);
    }

}
