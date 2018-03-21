package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <pre>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 *
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 * Example 2:
 * <pre>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 *
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 * Created by cyanflxy on 2018/3/21.
 */

public class _70_Climbing_Stairs {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _70_Climbing_Stairs object = new _70_Climbing_Stairs();
        System.out.println(object.climbStairs(1));
        System.out.println(object.climbStairs(2));
        System.out.println(object.climbStairs(3));
        System.out.println(object.climbStairs(4));
        System.out.println(object.climbStairs(5));
        System.out.println(object.climbStairs(6));
        System.out.println(object.climbStairs(43));
        System.out.println(object.climbStairs(45));

    }

    // Fibonacci ...
    public int climbStairs(int n) {
        long r = 0;

        for (int i = 0, j = n; i <= n / 2; i++, j -= 2) {
            r += count(i, j);
        }

        return (int) r;
    }

    private long count(int n, int m) {
        m++;
        long r = 1;
        for (int i = 1; i <= n; i++, m++) {
            r = r * m / i;
        }
        return r;
    }

//    迭代 Fibonacci， 速度慢很多. 使用数组计算会更快
//    public int climbStairs2(int n) {
//        int p0 = 1;
//        int p1 = 1;
//        int r = p1;
//
//        for (int i = 2; i <= n; i++) {
//            r = p1 + p0;
//            p0 = p1;
//            p1 = r;
//        }
//
//        return r;
//    }

//    public int climbStairs3(int n) {
//        int[] f = new int[n + 1];
//        f[0] = 1;
//        f[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            f[i] = f[i - 1] + f[i - 2];
//        }
//
//        return f[n];
//    }
}
