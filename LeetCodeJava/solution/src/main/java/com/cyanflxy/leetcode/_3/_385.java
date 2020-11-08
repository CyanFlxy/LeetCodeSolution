package com.cyanflxy.leetcode._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _385 {

    public static void main(String... args) {
//        new _385().deserialize("[123,[456,[789]]]");
        new _385().deserialize("[[],[[[[]],-4],[[[]],[0],[[]]]]]");
    }

    public NestedInteger deserialize(String s) {
        if (s.length() == 0) {
            return new NestedInteger();
        }

        if (s.charAt(0) == '[') {
            List<String> subStr = new ArrayList<>();
            int startIndex = 1;
            int inner = 0;
            for (int i = 1; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    inner++;
                } else if (c == ']') {
                    inner--;
                }
                if (inner > 0) {
                    continue;
                }

                if (c == ',') {
                    subStr.add(s.substring(startIndex, i));
                    startIndex = i + 1;
                }
            }
            subStr.add(s.substring(startIndex, s.length() - 1));

            NestedInteger result = new NestedInteger();
            for (String str : subStr) {
                if (str.length() > 0) {
                    result.add(deserialize(str));
                }
            }
            return result;
        }

        int index = 0;
        int flag = 1;
        if (s.charAt(0) == '-') {
            index = 1;
            flag = -1;
        }

        int num = 0;
        for (; index < s.length(); index++) {
            num = num * 10 + s.charAt(index) - '0';
        }

        return new NestedInteger(flag * num);
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
