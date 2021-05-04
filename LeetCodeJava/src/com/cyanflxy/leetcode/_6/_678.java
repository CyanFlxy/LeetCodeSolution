package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2021.05.04
 */
public class _678 {
    public boolean checkValidString(String s) {
        int left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            left += (s.charAt(i) == ')') ? -1 : 1;
            right += (s.charAt(n - i - 1) == '(') ? -1 : 1;
            if (left < 0 || right < 0) {
                return false;
            }
        }
        return true;
    }
}
