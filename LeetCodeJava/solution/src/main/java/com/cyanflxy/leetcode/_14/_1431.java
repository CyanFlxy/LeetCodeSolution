package com.cyanflxy.leetcode._14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/9/29
 */
public class _1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int n : candies) {
            max = n > max ? n : max;
        }

        max -= extraCandies;
        List<Boolean> result = new ArrayList<>();

        for (int n : candies) {
            result.add(n >= max);
        }

        return result;
    }
}
