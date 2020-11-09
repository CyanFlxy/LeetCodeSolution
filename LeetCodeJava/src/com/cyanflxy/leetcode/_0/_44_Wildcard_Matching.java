package com.cyanflxy.leetcode._0;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/wildcard-matching/description/
 * <p>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <pre>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * </pre>
 * Created by cyanflxy on 2018/3/7.
 */

public class _44_Wildcard_Matching {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _44_Wildcard_Matching object = new _44_Wildcard_Matching();

        System.out.println(!object.isMatch("aa", "a"));
        System.out.println(object.isMatch("aa", "aa"));
        System.out.println(!object.isMatch("aaa", "aa"));
        System.out.println(object.isMatch("aa", "*"));
        System.out.println(object.isMatch("aa", "a*"));
        System.out.println(object.isMatch("ab", "?*"));
        System.out.println(!object.isMatch("aab", "c*a*b"));
    }

    //解决方案太慢。 查看更快速的版本，着重注意*的处理。
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        if (pLen == 0) {
            return sLen == 0;
        }

        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        Set<Integer> matchingSet = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();
        Set<Integer> switchSet;
        matchingSet.add(-1);

        int pattenCursor = 0;

        while (pattenCursor < pLen) {
            char pChar = pArray[pattenCursor];

            if (pChar == '*') {

                for (int i : matchingSet) {
                    for (int j = i; j < sLen; j++) {
                        tempSet.add(j);
                    }
                }

                pattenCursor++;
            } else {
                if (pChar == '?') {
                    for (int i : matchingSet) {
                        if (i + 1 < sLen) {
                            tempSet.add(i + 1);
                        }
                    }
                } else {
                    for (int i : matchingSet) {
                        if (i + 1 < sLen && sArray[i + 1] == pChar) {
                            tempSet.add(i + 1);
                        }
                    }
                }

                pattenCursor++;
            }

            switchSet = matchingSet;
            matchingSet = tempSet;
            tempSet = switchSet;
            tempSet.clear();

        }

        return matchingSet.contains(sLen - 1);
    }
}
