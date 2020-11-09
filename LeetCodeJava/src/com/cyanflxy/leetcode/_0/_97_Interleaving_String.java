package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/interleaving-string/description/
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <pre>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * </pre>
 * Example 2:
 * <pre>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * </pre>
 * Created by cyanflxy on 2018/5/25.
 */

public class _97_Interleaving_String {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _97_Interleaving_String object = new _97_Interleaving_String();
        System.out.println(object.isInterleave("a", "b", "ab")); // true
        System.out.println(object.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(object.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
        System.out.println(object.isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac")); // true
    }

    // 最快的方案，在较慢的基础上添加了缓存
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) {
            return s2 != null && s2.equals(s3);
        }
        if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 + l2 != l3) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int[][] memory = new int[l1 + 1][l2 + 1];

        return isInterleave(c1, c2, c3, 0, 0, 0, memory);
    }

    private boolean isInterleave(char[] c1, char[] c2, char[] c3,
                                 int s1, int s2, int s3,
                                 int[][] memory) {
        if (s3 == c3.length) {
            return true;
        }

        if (memory[s1][s2] != 0) {
            return memory[s1][s2] == 1;
        }

        boolean left = false;
        boolean right = false;

        if (s1 < c1.length && c1[s1] == c3[s3]) {
            left = isInterleave(c1, c2, c3, s1 + 1, s2, s3 + 1, memory);
        }
        if (s2 < c2.length && c2[s2] == c3[s3]) {
            right = isInterleave(c1, c2, c3, s1, s2 + 1, s3 + 1, memory);
        }

        if (left || right) {
            memory[s1][s2] = 1;
            return true;
        } else {
            memory[s1][s2] = -1;
            return false;
        }
    }


//    // 可行但是特别慢的方案
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1 == null || s1.length() == 0) {
//            return s2 != null && s2.equals(s3);
//        }
//        if (s2 == null || s2.length() == 0) {
//            return s1.equals(s3);
//        }
//
//        int l1 = s1.length();
//        int l2 = s2.length();
//        int l3 = s3.length();
//
//        if (l1 + l2 != l3) {
//            return false;
//        }
//
//        char[] c1 = s1.toCharArray();
//        char[] c2 = s2.toCharArray();
//        char[] c3 = s3.toCharArray();
//
//        return isInterleave(c1, c2, c3, 0, 0, 0);
//    }
//
//    private boolean isInterleave(char[] c1, char[] c2, char[] c3,
//                                 int s1, int s2, int s3) {
//        if (s1 < c1.length && c1[s1] == c3[s3]) {
//            if (isInterleave(c1, c2, c3, s1 + 1, s2, s3 + 1)) {
//                return true;
//            }
//        }
//        if (s2 < c2.length && c2[s2] == c3[s3]) {
//            if (isInterleave(c1, c2, c3, s1, s2 + 1, s3 + 1)) {
//                return true;
//            }
//        }
//        return s1 >= c1.length && s2 >= c2.length;
//    }

}
