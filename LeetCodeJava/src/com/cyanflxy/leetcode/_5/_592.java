package com.cyanflxy.leetcode._5;

import javafx.util.Pair;

public class _592 {
    private int expIndex = 0;

    public String fractionAddition(String expression) {
        Pair<Integer, Integer> result = new Pair<>(0, 1);
        Pair<Integer, Integer> fraction;

        while ((fraction = readFraction(expression)) != null) {
            result = add(result, fraction);
        }

        return getExp(result);
    }

    private Pair<Integer, Integer> readFraction(String exp) {
        int a = 0;
        int b = 0;
        int sign = 1;
        boolean haveA = false;

        while (expIndex < exp.length()) {
            char c = exp.charAt(expIndex);
            if (c == '+' || c == '-') {
                if (haveA) {
                    break;
                } else {
                    if (c == '-') {
                        sign = -1;
                    }
                }
            } else if (c == '/') {
                haveA = true;
            } else {
                if (!haveA) {
                    a = a * 10 + (c - '0');
                } else {
                    b = b * 10 + (c - '0');
                }
            }

            expIndex++;
        }

        if (haveA) {
            return new Pair<>(a * sign, b);
        } else {
            return null;
        }
    }

    private Pair<Integer, Integer> add(Pair<Integer, Integer> f1, Pair<Integer, Integer> f2) {
        int a = f1.getKey() * f2.getValue() + f2.getKey() * f1.getValue();
        int b = f1.getValue() * f2.getValue();
        return new Pair<>(a, b);
    }

    private String getExp(Pair<Integer, Integer> fraction) {
        int a = fraction.getKey();
        if (a == 0) {
            return "0/1";
        }

        int b = fraction.getValue();
        int gcd = getGreatestCommonDivisor(Math.abs(a), b);
        a /= gcd;
        b /= gcd;
        return a + "/" + b;
    }

    private int getGreatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            int c = a % b;
            if (c == 0) {
                return b;
            } else {
                return getGreatestCommonDivisor(b, c);
            }
        } else {
            return getGreatestCommonDivisor(b, a);
        }
    }
}
