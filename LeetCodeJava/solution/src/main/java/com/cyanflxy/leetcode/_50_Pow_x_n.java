package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/powx-n/description/
 * <p>
 * Implement pow(x, n).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Created by cyanflxy on 2018/3/8.
 */

public class _50_Pow_x_n {


    public static void main(String... args) {
        test();
    }

    private static void test() {
        _50_Pow_x_n object = new _50_Pow_x_n();
        System.out.println(object.myPow(2d, 10));
        System.out.println(object.myPow(2d, -3));
        System.out.println(object.myPow(2d, Integer.MIN_VALUE));
        System.out.println(object.myPow(0.00001, Integer.MAX_VALUE));
    }

    public double myPow(double x, int n) {
        if (Double.compare(x, 0) == 0) {
            return 0;
        }

        if (n > 0) {
            n = -n;
            x = 1 / x;
        }

        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result /= x;
            }
            n /= 2;
            x *= x;
        }

        return result;
    }

}
