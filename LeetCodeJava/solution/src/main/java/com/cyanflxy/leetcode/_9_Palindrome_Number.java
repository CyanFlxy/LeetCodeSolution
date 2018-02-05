package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * Created by cyanflxy on 2018/2/5.
 */

public class _9_Palindrome_Number {

    public static void main(String... args) {
        boolean result = new _9_Palindrome_Number()
                .isPalindrome(-14241);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int result = 0;
        int temp = x;
        while (temp > 0) {
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }

        return result == x;
    }
}
