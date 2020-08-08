package com.cyanflxy.leetcode.interview;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _1 {

    public static void main(String... args) {
        new _1().longestPalindrome("abccccdd");

    }

    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int len = 0;
        char last = ' ';
        int count = 0;

        for (char c : arr) {
            if (last == c) {
                count++;
            } else {
                len = len + count / 2 * 2;
                count = 1;
                last = c;
            }
        }
        len = len + count / 2 * 2;

        return arr.length == len ? len : len + 1;
    }
}
