package com.cyanflxy.leetcode._0;

import java.util.Random;

/**
 * https://leetcode.com/problems/divide-two-integers/description/
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 * <p>
 * Created by cyanflxy on 2018/2/28.
 */

public class _29_Divide_Two_Integers {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _29_Divide_Two_Integers object = new _29_Divide_Two_Integers();

        System.out.println(object.test(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(object.test(Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(object.test(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(object.test(Integer.MAX_VALUE, Integer.MAX_VALUE));

        System.out.println(object.test(367, 1));
        System.out.println(object.test(23434, 1));
        System.out.println(object.test(567, 2));
        System.out.println(object.test(9888, 4));

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            System.out.println(object.test(random.nextInt(), random.nextInt()));
        }

    }

    private boolean test(int a, int b) {
//        System.out.println(a + "/" + b);
        return divide(a, b) == (a / b);
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("/ by zero");
        } else if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor > 0) {
                return -1 - divide(-(dividend + divisor), divisor);
            } else {
                return 1 + divide(divisor - dividend, -divisor);
            }
        }

        if (dividend < 0) {
            if (divisor > 0) {
                return -divide(-dividend, divisor);
            } else {
                return divide(-dividend, -divisor);
            }
        } else if (dividend > 0) {
            if (divisor < 0) {
                return -divide(dividend, -divisor);
            }
        } else if (dividend == 0) {
            return 0;
        }

        // 0x8FFFFFFF
        int K = 31;
        int X = 0x40000000;
        while ((divisor & X) == 0) {
            X >>= 1;
            K--;
        }

        if (X == divisor) {
            return dividend >> K - 1;
        }

        int P = 31;
        int result = 0;
        X = 0x40000000;

        while (dividend >= divisor) {
            if ((dividend & X) != 0) {
                int current = divisor << (P - K);
                if (dividend >= current) {
                    dividend -= current;
                    result += (1 << (P - K));
                } else {
                    dividend -= current >> 1;
                    result += (1 << (P - K - 1));
                }
            }

            X >>= 1;
            P--;
        }

        return result;
    }

}
