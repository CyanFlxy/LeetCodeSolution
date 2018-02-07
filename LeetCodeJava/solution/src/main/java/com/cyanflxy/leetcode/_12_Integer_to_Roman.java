package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/description/
 * <p>
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Created by cyanflxy on 2018/2/7.
 */

public class _12_Integer_to_Roman {
    public static void main(String... args) {
        test();
    }

    private static void test() {
        _12_Integer_to_Roman object = new _12_Integer_to_Roman();

        System.out.println(object.intToRoman(1).equals("I"));
        System.out.println(object.intToRoman(3999).equals("MMMCMXCIX"));
    }

    private static char[][] ROMAN_CHAR = {
            {'I', 'V', 'X'},
            {'X', 'L', 'C'},
            {'C', 'D', 'M'},
            {'M', '\0', '\0'}};

    public String intToRoman(int num) {

        int cursor = 0;
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int digit = num % 10;
            char c1 = ROMAN_CHAR[cursor][0];
            char c5 = ROMAN_CHAR[cursor][1];
            char cX = ROMAN_CHAR[cursor][2];

            switch (digit) {
                case 1:
                    sb.append(c1);
                    break;
                case 2:
                    sb.append(c1);
                    sb.append(c1);
                    break;
                case 3:
                    sb.append(c1);
                    sb.append(c1);
                    sb.append(c1);
                    break;
                case 4:
                    sb.append(c5);
                    sb.append(c1);
                    break;
                case 5:
                    sb.append(c5);
                    break;
                case 6:
                    sb.append(c1);
                    sb.append(c5);
                    break;
                case 7:
                    sb.append(c1);
                    sb.append(c1);
                    sb.append(c5);
                    break;
                case 8:
                    sb.append(c1);
                    sb.append(c1);
                    sb.append(c1);
                    sb.append(c5);
                    break;
                case 9:
                    sb.append(cX);
                    sb.append(c1);
                    break;
                case 0:
                    break;
            }

            cursor++;
            num = num / 10;
        }


        return sb.reverse().toString();
    }

// 可读性更好的写法
//    private static String M[] = {"", "M", "MM", "MMM"};
//    private static String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//    private static String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//    private static String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//
//    public String intToRoman(int num) {
//        StringBuilder sb = new StringBuilder(20);
//        return sb.append(M[num / 1000])
//                .append(C[(num % 1000) / 100])
//                .append(X[(num % 100) / 10])
//                .append(I[num % 10])
//                .toString();
//    }

}
