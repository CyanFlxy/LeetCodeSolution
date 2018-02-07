package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Created by cyanflxy on 2018/2/7.
 */

public class _13_Roman_to_Integer {
    public static void main(String... args) {
        test();
    }

    private static void test() {
        _13_Roman_to_Integer object = new _13_Roman_to_Integer();

        System.out.println(object.romanToInt("I") == 1);
        System.out.println(object.romanToInt("MMMCMXCIX") == 3999);
    }


    public int romanToInt(String s) {
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M':// 1000
                    result += 1000;
                    break;
                case 'D':// 500
                    result += 500;
                    break;
                case 'C':// 100
                    if (result >= 500) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                case 'L':// 50
                    result += 50;
                    break;
                case 'X':// 10
                    if (result >= 50) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'V':// 5
                    result += 5;
                    break;
                case 'I':// 1
                    if (result >= 5) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
            }
        }

        return result;
    }
}
