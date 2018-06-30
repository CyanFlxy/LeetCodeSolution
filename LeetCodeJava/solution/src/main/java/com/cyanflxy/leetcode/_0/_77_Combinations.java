package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/description/
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <pre>
 * [
 *      [2,4],
 *      [3,4],
 *      [2,3],
 *      [1,2],
 *      [1,3],
 *      [1,4],
 * ]
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/3/28.
 */

public class _77_Combinations {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _77_Combinations object = new _77_Combinations();

        System.out.println(object.combine(4, 4));
        System.out.println(object.combine(4, 3));
        System.out.println(object.combine(4, 2));
        System.out.println(object.combine(4, 1));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || k > n) {
            return result;
        }

        Integer[] array = new Integer[k];
        fetchNumber(result, array, 0, 1, n, k);

        return result;
    }

    private void fetchNumber(List<List<Integer>> result,
                             Integer[] pool, int poolIndex,
                             int from, int to, int count) {
        if (count == 0) {
            Integer[] arr = new Integer[pool.length];
            System.arraycopy(pool, 0, arr, 0, pool.length);
            result.add(Arrays.asList(arr));

        } else {
            int freeCount = to - from - count + 2;
            for (int i = 0; i < freeCount; i++) {
                pool[poolIndex] = from + i;
                fetchNumber(result, pool, poolIndex + 1, from + i + 1, to, count - 1);
            }
        }

    }
}
