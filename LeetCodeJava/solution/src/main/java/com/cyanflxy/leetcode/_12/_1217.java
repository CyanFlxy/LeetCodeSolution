package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _1217 {

    public int minCostToMoveChips(int[] position) {
        int result = 0;

        for (int i : position) {
            result += i & 1;
        }

        return Math.min(result, position.length - result);
    }

}
