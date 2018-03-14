package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/unique-paths/description/
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Created by cyanflxy on 2018/3/14.
 */

public class _62_Unique_Paths {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _62_Unique_Paths object = new _62_Unique_Paths();
//        System.out.println(object.uniquePaths(51, 9));
        System.out.println(object.uniquePaths(1, 9));
    }

    public int uniquePaths(int m, int n) {
        // 交换n为较小值应该会更快些，但是Math.min/max好像不如直接值交换
        long result = 1;
        for (int i = 1; i < n; i++, m++)
            result = result * m / i;
        return (int) result;
    }

}
