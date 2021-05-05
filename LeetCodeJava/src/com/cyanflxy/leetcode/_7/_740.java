package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.05
 */
public class _740 {
    public static void main(String[] args) {
        int result = new _740().deleteAndEarn(new int[]{
                10, 8, 4, 2, 1, 3, 4, 8, 2, 9, 10, 4, 8, 5, 9, 1, 5, 1,
                6, 8, 1, 1, 6, 7, 8, 9, 1, 7, 6, 8, 4, 5, 4, 1, 5, 9, 8,
                6, 10, 6, 4, 3, 8, 4, 10, 8, 8, 10, 6, 4, 4, 4, 9, 6, 9,
                10, 7, 1, 5, 3, 4, 4, 8, 1, 1, 2, 1, 4, 1, 1, 4, 9, 4, 7,
                1, 5, 1, 10, 3, 5, 10, 3, 10, 2, 1, 10, 4, 1, 1, 4, 1, 2,
                10, 9, 7, 10, 1, 2, 7, 5});
        System.out.println(result);
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        int last = -1;
        int result = 0;
        List<Integer> sums = new ArrayList<>();
        int size = 0;

        for (int n : nums) {
            if (n - last > 1) {
                result += rob(sums);
                sums.clear();
                sums.add(n);
                size = 0;
            } else if (n == last) {
                sums.set(size, sums.get(size) + n);
            } else {
                size++;
                sums.add(n);
            }


            last = n;
        }
        result += rob(sums);

        return result;
    }

    private int rob(List<Integer> sums) {
        if (sums.isEmpty()) {
            return 0;
        }

        int last1 = 0;
        int last2 = 0;
        int current = 0;
        for (Integer s : sums) {
            current = Math.max(s + last1, last2);
            last1 = last2;
            last2 = current;
        }
        return current;
    }
}
