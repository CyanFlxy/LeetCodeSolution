package com.cyanflxy.leetcode._1;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _125 {

    public static void main(String... args) {
        new _125().isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }


}