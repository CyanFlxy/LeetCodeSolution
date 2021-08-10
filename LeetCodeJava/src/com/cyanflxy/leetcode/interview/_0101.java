package com.cyanflxy.leetcode.interview;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.08.10
 */
public class _0101 {
    public boolean isUnique(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
