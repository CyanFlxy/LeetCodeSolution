package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2021.06.24
 */
public class _1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int v = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                v++;
                if (v > 1) {
                    sb.append(c);
                }
            } else {
                if (v > 1) {
                    sb.append(c);
                }
                v--;
            }

        }
        return sb.toString();
    }
}
