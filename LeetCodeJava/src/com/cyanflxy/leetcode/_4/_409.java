package com.cyanflxy.leetcode._4;

public class _409 {
    public int longestPalindrome(String s) {
        int[] count = new int[52];

        for (char ch : s.toCharArray()) {
            if (ch <= 'Z') {
                count[ch - 'A']++;
            } else {
                count[ch - 'a' + 26]++;
            }
        }

        boolean haveSingle = false;
        int result = 0;
        for (int i : count) {
            if (i % 2 == 0) {
                result += i;
            } else {
                result += i - 1;
                haveSingle = true;
            }
        }
        if (haveSingle) {
            result++;
        }
        return result;
    }
}
