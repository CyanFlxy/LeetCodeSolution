package com.cyanflxy.leetcode._0;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 * <p>
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * <pre>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * </pre>
 * <p>
 * Created by cyanflxy on 2018/2/6.
 */

public class _10_Regular_Expression_Matching {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _10_Regular_Expression_Matching object = new _10_Regular_Expression_Matching();
        System.out.println(object.isMatch("aa", "a"));
        System.out.println(object.isMatch("aa", "aa"));
        System.out.println(object.isMatch("aaa", "aa"));
        System.out.println(object.isMatch("aa", "a*"));
        System.out.println(object.isMatch("aa", ".*"));
        System.out.println(object.isMatch("aa", ".*"));
        System.out.println(object.isMatch("aab", "c*a*b"));
    }

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

            if (pattenCursor + 1 < pLen && pArray[pattenCursor + 1] == '*') {

                if (pChar == '.') {
                    for (int i : matchingSet) {
                        for (int j = i; j < sLen; j++) {
                            tempSet.add(j);
                        }
                    }
                } else {
                    for (int i : matchingSet) {

                        do {
                            tempSet.add(i);
                            i++;
                        } while (i < sLen && sArray[i] == pChar);

                    }
                }

                pattenCursor += 2;
            } else {
                if (pChar == '.') {
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
