package com.cyanflxy.leetcode._0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <pre>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * </pre>
 * Created by cyanflxy on 2018/2/24.
 */

public class _22_Generate_Parentheses {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _22_Generate_Parentheses object = new _22_Generate_Parentheses();

        System.out.println(object.generateParenthesis(4));
    }


    public List<String> generateParenthesis(int n) {
        Set<String> result = generateParenthesisSet(n);
        List<String> r = new ArrayList<>(result);
        Collections.sort(r);
        return r;
    }

    // 数据结构使用没有优势。 递归方式效率低下，应该按照地图搜索方式递归，尝试添加左括号或右括号。
    private Set<String> generateParenthesisSet(int n) {
        Set<String> result = new HashSet<>();

        if (n == 1) {
            result.add("()");

        } else if (n == 2) {
            result.add("()()");
            result.add("(())");

        } else {

            for (int index = 1; index <= n / 2; index++) {
                Set<String> left = generateParenthesisSet(index);
                Set<String> right = generateParenthesisSet(n - index);

                for (String ls : left) {
                    for (String rs : right) {
                        result.add(ls + rs);
                        result.add(rs + ls);
                    }
                }

                for (String ls : left) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n - index; i++) {
                        sb.insert(0, "(");
                        sb.append(")");
                    }
                    sb.insert(n - index, ls);
                    result.add(sb.toString());
                }
                for (String rs : right) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < index; i++) {
                        sb.insert(0, "(");
                        sb.append(")");
                    }
                    sb.insert(index, rs);
                    result.add(sb.toString());

                }
            }

        }

        return result;
    }

}
