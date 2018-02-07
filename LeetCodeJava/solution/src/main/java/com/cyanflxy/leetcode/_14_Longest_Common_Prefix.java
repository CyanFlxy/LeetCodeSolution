package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * Created by cyanflxy on 2018/2/7.
 */
public class _14_Longest_Common_Prefix {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _14_Longest_Common_Prefix object = new _14_Longest_Common_Prefix();

        System.out.println(object.longestCommonPrefix(new String[]{"I"}).equals("I"));
        System.out.println(object.longestCommonPrefix(new String[]{"abc", "aaa", "ade"}).equals("a"));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String common = strs[0];

        for (int i = 1; i < strs.length; i++) {
            common = commonPrefix(common, strs[i]);
        }

        return common;
    }

    public String commonPrefix(String str1, String str2) {

        int index;
        for (index = 0; index < str1.length() && index < str2.length(); index++) {
            if (str1.charAt(index) != str2.charAt(index)) {
                break;
            }
        }

        return str1.substring(0, index);
    }
}
