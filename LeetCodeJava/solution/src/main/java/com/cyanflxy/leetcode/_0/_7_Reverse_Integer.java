package com.cyanflxy.leetcode._0;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.<p>
 * Example 1:
 * <pre>
 * Input: 123
 * Output:  321
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 * Input: -123
 * Output: -321
 * </pre>
 * <p>
 * Example 3:
 * <pre>
 * Input: 120
 * Output: 21
 * </pre>
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Created by cyanflxy on 2018/2/3.
 */

public class _7_Reverse_Integer {

    public static void main(String... args) {
        int result = new _7_Reverse_Integer()
                .reverse(1463847412);//2147483647
        System.out.println(result);
    }

    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return -reverse(-x);
        }

        int result = 0;
        int maxResult = Integer.MAX_VALUE / 10;
        while (x > 0) {
            if (result > maxResult) {
                return 0;
            }

            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
