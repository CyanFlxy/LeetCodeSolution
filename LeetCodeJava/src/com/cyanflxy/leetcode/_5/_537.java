package com.cyanflxy.leetcode._5;

import javafx.util.Pair;

public class _537 {
    public String complexNumberMultiply(String a, String b) {
        Pair<Integer, Integer> c1 = getComplexNumber(a);
        Pair<Integer, Integer> c2 = getComplexNumber(b);
        int x = c1.getKey() * c2.getKey() - c1.getValue() * c2.getValue();
        int y = c1.getKey() * c2.getValue() + c1.getValue() * c2.getKey();
        return x + "+" + y + "i";
    }

    private Pair<Integer, Integer> getComplexNumber(String s) {
        int a = 0;
        int b = 0;
        int sign = 1;
        boolean haveA = false;

        for (char c : s.toCharArray()) {
            if (c == '+') {
                haveA = true;
                a *= sign;
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == 'i') {
                b *= sign;
            } else {
                if (haveA) {
                    b = b * 10 + c - '0';
                } else {
                    a = a * 10 + c - '0';
                }
            }
        }

        return new Pair<>(a, b);
    }
}
