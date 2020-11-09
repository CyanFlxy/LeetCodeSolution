package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <pre>
 * Input: "Hello World"
 * Output: 5
 * </pre>
 * Created by cyanflxy on 2018/3/6.
 */

public class _58_Length_of_Last_Word {


    public static void main(String... args) {
        test();
    }

    private static void test() {
        _58_Length_of_Last_Word object = new _58_Length_of_Last_Word();

        System.out.println(object.lengthOfLastWord(" abda``c "));
    }

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        int result = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            result++;
        }
        return result;
    }
}
