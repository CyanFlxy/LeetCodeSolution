package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/sqrtx/description/
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * <p>
 * Example 1:
 * <pre>
 * Input: 4
 * Output: 2
 * </pre>
 * Example 2:
 * <pre>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842...,
 * and since we want to return an integer, the decimal part will be truncated.
 * </pre>
 * Created by cyanflxy on 2018/3/20.
 */

public class _69_Sqrt_x {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _69_Sqrt_x object = new _69_Sqrt_x();
        System.out.println(object.mySqrt(0));
        System.out.println(object.mySqrt(16));

        System.out.println(object.mySqrt(178 * 178 - 1));
        System.out.println(object.mySqrt(2147395599));//2147483647
    }

    // 可以用二分法，查找平方小于x的值
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double p = 0;
        double r = 1;
        while (Math.abs(p - r) >= 1) {
            p = r;
            r = (p + x / p) / 2;
        }

        return (int) r;
    }
}
