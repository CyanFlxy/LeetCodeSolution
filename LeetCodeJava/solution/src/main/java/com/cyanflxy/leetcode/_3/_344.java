package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/1/21
 */
public class _344 {

    public void reverseString(char[] s) {
        char tmp;
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            int t = len - i - 1;
            tmp = s[i];
            s[i] = s[t];
            s[t] = tmp;
        }
    }
}
