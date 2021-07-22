package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.07.22
 */
public class _856 {

    public static void main(String[] args) {
        System.out.println(new _856().scoreOfParentheses("()"));
        System.out.println(new _856().scoreOfParentheses("(())"));
        System.out.println(new _856().scoreOfParentheses("(())()"));
        System.out.println(new _856().scoreOfParentheses("()()()"));
    }

    int index = 0;

    public int scoreOfParentheses(String s) {
        if (index >= s.length()) {
            return 0;
        }

        if (s.charAt(index) == ')') {
            return 0;
        }
        index++;//第一个字符永远是左括号(

        char chNext = s.charAt(index);
        if (chNext == ')') {
            index++;
            return 1 + scoreOfParentheses(s);
        } else {
            int score = scoreOfParentheses(s);
            index++;
            return 2 * score + scoreOfParentheses(s);
        }
    }
}
