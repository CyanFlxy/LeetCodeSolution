package com.cyanflxy.leetcode.interview;

import java.util.Arrays;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 *
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
