package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2020/1/21
 */
public class _459 {

    public boolean repeatedSubstringPattern(String s) {
        String s2 = s + s;
        return s2.substring(1, s2.length() - 1).contains(s);
    }

}
