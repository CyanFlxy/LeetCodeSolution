package com.cyanflxy.leetcode._1;

import java.util.HashMap;

/**
 * @author cyanflxy
 * @since 2021.07.17
 */
public class _166 {

    public static void main(String[] args) {
//        System.out.println(new _166().fractionToDecimal(1, 2));
//        System.out.println(new _166().fractionToDecimal(2, 1));
        System.out.println(new _166().fractionToDecimal(2, 3));
        System.out.println(new _166().fractionToDecimal(4, 333));
        System.out.println(new _166().fractionToDecimal(1, 5));
        System.out.println(new _166().fractionToDecimal(1, 2));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        long a = numerator;
        long b = denominator;

        StringBuilder result = new StringBuilder();
        if (a < 0) {
            a = -a;
            if (b > 0) {
                result.append('-');
            } else {
                b = -b;
            }
        } else if (b < 0) {
            result.append('-');
            b = -b;
        }

        result.append(a / b);

        a = a % b;
        if (a == 0) {
            return result.toString();
        }

        result.append('.');

        HashMap<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            if (map.containsKey(a)) {
                result.append(')');
                int index = map.get(a);
                result.insert(index, '(');
                break;
            }
            int s = (int) (a * 10 / b);
            result.append(s);
            map.put(a, result.length() - 1);
            a = (a * 10) % b;
        }
        return result.toString();
    }
}
