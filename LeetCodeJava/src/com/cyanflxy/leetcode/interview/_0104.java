package com.cyanflxy.leetcode.interview;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.08.10
 */
public class _0104 {
    public boolean canPermutePalindrome(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        boolean singleUsed = false;
        for (int i = 0; i < arr.length; ) {
            if (i + 1 < arr.length) {
                if (arr[i] != arr[i + 1]) {
                    if (singleUsed) {
                        return false;
                    } else {
                        singleUsed = true;
                    }
                    i++;
                } else {
                    i += 2;
                }
            } else {
                return !singleUsed;
            }
        }
        return true;
    }
}
