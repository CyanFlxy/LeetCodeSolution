package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/multiply-strings/description/
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <ol>
 * <li>The length of both num1 and num2 is < 110.</li>
 * <li>Both num1 and num2 contains only digits 0-9.</li>
 * <li>Both num1 and num2 does not contain any leading zero.</li>
 * <li>You must not use any built-in BigInteger library or convert the inputs to integer directly.</li>
 * </ol>
 * Created by cyanflxy on 2018/3/7.
 */

public class _43_Multiply_Strings {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _43_Multiply_Strings object = new _43_Multiply_Strings();

        System.out.println(object.multiply("12345", "56780"));//700949100
    }


    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();
        int[] n1 = new int[l1];
        int[] n2 = new int[l2];
        int[] result = new int[l1 + l2];

        for (int i = 0; i < l1; i++) {
            n1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < l2; i++) {
            n2[i] = num2.charAt(i) - '0';
        }

        for (int i1 = l1 - 1; i1 >= 0; i1--) {
            for (int i2 = l2 - 1; i2 >= 0; i2--) {
                int value = result[i1 + i2 + 1] + n1[i1] * n2[i2];
                result[i1 + i2 + 1] = value % 10;
                result[i1 + i2] += value / 10;
            }
        }

        StringBuilder sb = new StringBuilder(result.length);
        for (int i : result) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            sb.append(i);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

//    private String[] times;
//
//    public String multiply(String num1, String num2) {
//        if ("0".equals(num1) || "0".equals(num2)) {
//            return "0";
//        }
//
//        times = new String[10];
//        times[0] = "0";
//        times[1] = num1;
//
//        String result = "0";
//        int zeroCount = 0;
//
//        for (int i = num2.length() - 1; i >= 0; i--, zeroCount++) {
//            int value = num2.charAt(i) - '0';
//            result = addString(result, addZero(getTimes(value), zeroCount));
//        }
//
//        return result;
//    }
//
//    private String getTimes(int t) {
//        if (times[t] == null) {
//            if (t % 2 == 0) {
//                times[t] = addString(getTimes(t / 2), getTimes(t / 2));
//            } else {
//                times[t] = addString(getTimes(t - 1), times[1]);
//            }
//        }
//
//        return times[t];
//    }
//
//    private String addString(String num1, String num2) {
//        int len1 = num1.length();
//        int len2 = num2.length();
//        StringBuilder sb = new StringBuilder(Math.max(len1, len2) + 1);
//
//        int carry = 0;
//        len1--;
//        len2--;
//
//        while (len1 >= 0 && len2 >= 0) {
//            int i1 = num1.charAt(len1) - '0';
//            int i2 = num2.charAt(len2) - '0';
//
//            int value = i1 + i2 + carry;
//            if (value >= 10) {
//                sb.append(value - 10);
//                carry = 1;
//            } else {
//                sb.append(value);
//                carry = 0;
//            }
//
//            len1--;
//            len2--;
//        }
//
//        while (len1 >= 0) {
//            int i1 = num1.charAt(len1) - '0';
//            int value = i1 + carry;
//            if (value >= 10) {
//                sb.append(value - 10);
//                carry = 1;
//            } else {
//                sb.append(value);
//                carry = 0;
//            }
//            len1--;
//        }
//
//        while (len2 >= 0) {
//            int i2 = num2.charAt(len2) - '0';
//            int value = i2 + carry;
//            if (value >= 10) {
//                sb.append(value - 10);
//                carry = 1;
//            } else {
//                sb.append(value);
//                carry = 0;
//            }
//            len2--;
//        }
//        if (carry == 1) {
//            sb.append('1');
//        }
//        return sb.reverse().toString();
//    }
//
//    private String addZero(String num1, int zeroCount) {
//        if (zeroCount == 0) {
//            return num1;
//        }
//
//        StringBuilder sb = new StringBuilder(num1.length() + zeroCount);
//        sb.append(num1);
//        for (int i = 0; i < zeroCount; i++) {
//            sb.append(0);
//        }
//        return sb.toString();
//    }
}
