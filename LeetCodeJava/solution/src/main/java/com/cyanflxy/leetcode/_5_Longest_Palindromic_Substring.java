package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <pre>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * </pre>
 * Example:
 * <pre>
 * Input: "cbbd"
 * Output: "bb"
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/2/2.
 */
public class _5_Longest_Palindromic_Substring {

    public static void main(String... args) {
        String str = "bababd";
        String result = new _5_Longest_Palindromic_Substring()
                .longestPalindrome(str);
        System.out.println(result);
    }

    private int length;

    public String longestPalindrome(String s) {

        length = s.length();

        int resultLength = 0;
        int maxIndex = 0;

        for (int i = 0; i < length; i++) {
            int evenLength = maxEvenLength(s, i);
            int oddLength = maxOddLength(s, i);

            if (oddLength < evenLength) {
                if (resultLength < evenLength) {
                    resultLength = evenLength;
                    maxIndex = i;
                }
            } else if (resultLength < oddLength) {
                resultLength = oddLength;
                maxIndex = i;
            }

        }

        int resultStart = maxIndex - resultLength / 2 + 1 - resultLength % 2;
        return s.substring(resultStart, resultStart + resultLength);
    }

    private int maxEvenLength(String s, int index) {

        int start = index;
        int end = index + 1;

        for (; start >= 0 && end < length; start--, end++) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }

        return end - start - 1;

    }

    private int maxOddLength(String s, int index) {

        int start = index - 1;
        int end = index + 1;

        for (; start >= 0 && end < length; start--, end++) {

            if (s.charAt(start) != s.charAt(end)) {
                break;
            }

        }

        return end - start - 1;
    }
}
