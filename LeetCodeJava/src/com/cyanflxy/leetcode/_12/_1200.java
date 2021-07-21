package com.cyanflxy.leetcode._12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.07.21
 */
public class _1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                result.clear();
                minDiff = diff;
                result.add(createList(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                result.add(createList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }

    private List<Integer> createList(int a, int b) {
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}
