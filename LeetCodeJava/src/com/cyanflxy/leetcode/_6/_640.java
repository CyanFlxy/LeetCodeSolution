package com.cyanflxy.leetcode._6;

import javafx.util.Pair;

public class _640 {
    public String solveEquation(String equation) {
        int equalIndex = equation.indexOf('=');
        Pair<Integer, Integer> left = simple(equation.substring(0, equalIndex));
        Pair<Integer, Integer> right = simple(equation.substring(equalIndex + 1));

        if (left.getKey() == right.getKey()) {
            if (left.getValue() == right.getValue()) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            int result = (right.getValue() - left.getValue()) / (left.getKey() - right.getKey());
            return "x=" + result;
        }
    }

    private Pair<Integer, Integer> simple(String exp) {
        int a = 0;
        int b = 0;

        int num = 0;
        int sign = 1;
        boolean haveNum = false;

        for (char ch : exp.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == 'x') {
                if (haveNum) {
                    num *= sign;
                    if (ch == 'x') {
                        a += num;
                    } else {
                        b += num;
                    }
                } else if (ch == 'x') {
                    a += sign;
                }

                haveNum = false;
                num = 0;
                sign = ch == '-' ? -1 : 1;
            } else {
                haveNum = true;
                num = num * 10 + ch - '0';
            }
        }

        if (haveNum) {
            num *= sign;
            b += num;
        }

        return new Pair<>(a, b);
    }
}
