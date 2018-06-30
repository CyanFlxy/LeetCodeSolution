package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <pre>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * </pre>
 * Example 2:
 * <pre>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/2/26.
 */

public class _28_Implement_strStr {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _28_Implement_strStr object = new _28_Implement_strStr();

        System.out.println(object.strStr("aaaaa", "bba"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int nl = needle.length();
        int max = haystack.length() - nl;
        for (int hi = 0; hi <= max; hi++) {
            int k = 0;
            for (; k < nl; k++) {
                if (needle.charAt(k) != haystack.charAt(k + hi)) {
                    break;
                }
            }

            if (k == nl) {
                return hi;
            }
        }

        return -1;
    }
}
