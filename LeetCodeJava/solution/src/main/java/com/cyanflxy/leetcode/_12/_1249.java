package com.cyanflxy.leetcode._12;

import java.util.LinkedList;

/**
 * @author cyanflxy
 * @since 2019/12/9
 */
public class _1249 {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();

        char[] arr = s.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            char c = arr[i];
            if (c == '(') {
                left.push(i);
            } else if (c == ')') {
                if (left.peek() != null) {
                    left.pop();
                } else {
                    right.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        while (true) {
            Integer leftValue = left.peek();
            Integer rightValue = right.peek();
            int index;

            if (leftValue != null && (rightValue == null || leftValue >= rightValue)) {
                left.pop();
                index = leftValue;
            } else if (rightValue != null && (leftValue == null || leftValue < rightValue)) {
                right.pop();
                index = rightValue;
            } else {
                break;
            }

            sb.replace(index, index + 1, "");
        }

        return sb.toString();
    }
}
