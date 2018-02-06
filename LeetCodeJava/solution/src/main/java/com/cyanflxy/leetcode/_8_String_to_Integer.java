package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * <p>
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * Created by cyanflxy on 2018/2/6.
 */

public class _8_String_to_Integer {

    public static void main(String... args) {
        // c, cc, abcabcd
        int result = new _8_String_to_Integer().myAtoi("  +3-123e45");
        System.out.println(result);
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        int len = str.length();
        if (len == 0) {
            return 0;
        }

        int start = 0;
        boolean positive = true;
        char first = str.charAt(0);
        if (first == '-') {
            start = 1;
            positive = false;
        } else if (first == '+') {
            start = 1;
        }


        int result = 0;
        int digit;
        int maxInt = Integer.MAX_VALUE / 10;

        for (int i = start; i < len; i++) {
            digit = str.charAt(i) - '0';
            if (0 <= digit && digit <= 9) {
                if (result > maxInt) {
                    if (positive) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (result == maxInt) {
                    if (positive) {
                        if (digit >= 7) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if (digit >= 8) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }

                result = result * 10 + digit;
            } else {
                break;
            }
        }


        if (positive) {
            return result;
        } else {
            return -result;
        }
    }
}
