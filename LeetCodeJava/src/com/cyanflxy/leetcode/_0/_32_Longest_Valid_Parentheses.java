package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * <p>
 * Created by cyanflxy on 2018/2/28.
 */

public class _32_Longest_Valid_Parentheses {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _32_Longest_Valid_Parentheses object = new _32_Longest_Valid_Parentheses();
        System.out.println(object.longestValidParentheses(")(()))") == 4);
        System.out.println(object.longestValidParentheses("(())") == 4);
        System.out.println(object.longestValidParentheses("((())") == 4);
        System.out.println(object.longestValidParentheses("(()") == 2);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int max = 0;
        int current = 0;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sum += 1;
            } else {
                sum -= 1;
            }

            current++;
            if (sum < 0) {
                current = 0;
                sum = 0;
            } else if (sum == 0) {
                if (current > max) {
                    max = current;
                }
            }
        }


        sum = 0;
        current = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                sum += 1;
            } else {
                sum -= 1;
            }

            current++;
            if (sum > 0) {
                current = 0;
                sum = 0;
            } else if (sum == 0) {
                if (current > max) {
                    max = current;
                }
            }
        }

        return max;
    }
}
