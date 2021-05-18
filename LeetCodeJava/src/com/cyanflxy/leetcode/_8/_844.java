package com.cyanflxy.leetcode._8;

import javafx.util.Pair;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _844 {
    public boolean backspaceCompare(String s, String t) {
        Pair<char[], Integer> ps = checkResult(s);
        Pair<char[], Integer> pt = checkResult(t);
        if (!ps.getValue().equals(pt.getValue())) {
            return false;
        }

        char[] cs = ps.getKey();
        char[] ct = pt.getKey();
        for (int i = 0; i < ps.getValue(); i++) {
            if (cs[i] != ct[i]) {
                return false;
            }
        }

        return true;
    }

    private Pair<char[], Integer> checkResult(String s) {
        char[] arr = new char[s.length()];
        int len = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (len > 0) {
                    len--;
                }
            } else {
                arr[len++] = ch;
            }
        }
        return new Pair<>(arr, len);
    }
}
