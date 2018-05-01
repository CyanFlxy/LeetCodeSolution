package com.cyanflxy.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/scramble-string/description/
 * <p>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <pre>
 *      great
 *     /    \
 *    gr    eat
 *   / \    /  \
 *  g   r  e   at
 *  / \
 * a   t
 * </pre>
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <pre>
 *       rgeat
 *      /    \
 *     rg    eat
 *    / \    /  \
 *   r   g  e   at
 *  / \
 * a   t
 * </pre>
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <pre>
 *       rgtae
 *      /    \
 *     rg    tae
 *    / \    /  \
 *   r   g  ta  e
 *  / \
 * t   a
 * </pre>
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * <p>
 * Created by cyanflxy on 2018/4/14.
 */
public class _87_Scramble_String {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _87_Scramble_String object = new _87_Scramble_String();

        System.out.println(object.isScramble("great", "rgeat"));//true
        System.out.println(object.isScramble("abcd", "bdac"));//false
        System.out.println(object.isScramble("abcd", "dacb"));//true
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        if (len != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) {
            return false;
        }
        if (len <= 3) {
            return true;
        }

        for (int i = 1; i < len; i++) {

            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
        }

        return false;
    }

}
