package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _392 {
    public boolean isSubsequence(String s, String t) {
        int ti = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (ti < t.length() && t.charAt(ti) != c) {
                ti++;
            }
            if (ti >= t.length()) {
                return false;
            }
            ti++;
        }
        return true;
    }
}
