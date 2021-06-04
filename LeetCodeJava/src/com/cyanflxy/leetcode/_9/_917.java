package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.06.04
 */
public class _917 {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        char[] result = new char[len];

        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            while (l < len && !isLetter(arr[l])) {
                result[l] = arr[l];
                l++;
            }

            while (h >= 0 && !isLetter(arr[h])) {
                result[h] = arr[h];
                h--;
            }

            if (l <= h) {
                result[l] = arr[h];
                result[h] = arr[l];
                h--;
                l++;
            }
        }

        return new String(result);
    }

    private boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
