package com.cyanflxy.leetcode.interview;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.08.10
 */
public class _0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 == s2;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] aar1 = s1.toCharArray();
        char[] aar2 = s2.toCharArray();
        Arrays.sort(aar1);
        Arrays.sort(aar2);

        for (int i = 0; i < aar1.length; i++) {
            if (aar1[i] != aar2[i]) {
                return false;
            }
        }

        return true;
    }
}
