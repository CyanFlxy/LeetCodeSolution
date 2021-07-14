package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2021.07.15
 */
public class _0109 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
