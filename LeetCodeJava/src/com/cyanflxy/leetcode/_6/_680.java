package com.cyanflxy.leetcode._6;

public class _680 {

    public static void main(String[] args) {
        new _680().validPalindrome("abc");
    }

    public boolean validPalindrome(String s) {
        int len = s.length() - 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i)) {
                return isPalindrome(s, i, len - i - 1)
                        || isPalindrome(s, i + 1, len - i);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (end - start < 1) {
            return true;
        }

        int mid = (start + end + 1) / 2;
        for (int i = start; i < mid; i++) {
            if (s.charAt(i) != s.charAt(end + start - i)) {
                return false;
            }
        }

        return true;
    }
}
