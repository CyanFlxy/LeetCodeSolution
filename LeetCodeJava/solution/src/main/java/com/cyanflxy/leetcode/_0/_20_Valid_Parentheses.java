package com.cyanflxy.leetcode._0;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Created by cyanflxy on 2018/2/22.
 */

public class _20_Valid_Parentheses {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _20_Valid_Parentheses object = new _20_Valid_Parentheses();

        System.out.println(object.isValid(""));
        System.out.println(!object.isValid("("));
        System.out.println(object.isValid("()[]{}"));
        System.out.println(!object.isValid("(("));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        // 这里可以改进，直接使用数组保存而不是现有的数据结构
        LinkedList<Character> parentheses = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                parentheses.addFirst(')');
            } else if (ch == '[') {
                parentheses.addFirst(']');
            } else if (ch == '{') {
                parentheses.addFirst('}');
            } else {
                if (parentheses.size() == 0) {
                    return false;
                }

                char prev = parentheses.removeFirst();
                if (prev != ch) {
                    return false;
                }
            }

        }

        return parentheses.size() == 0;
    }
}
