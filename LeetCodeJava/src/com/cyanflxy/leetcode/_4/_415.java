package com.cyanflxy.leetcode._4;

public class _415 {


    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.equals("") || num1.equals("0")) {
            return num2;
        }
        if (num2 == null || num2.equals("") || num2.equals("0")) {
            return num1;
        }

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (; i >= 0 && j >= 0; i--, j--) {
            int x = arr1[i] + arr2[j] + carry - '0' * 2;
            if (x >= 10) {
                x -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append((char) ('0' + x));
        }

        while (i >= 0) {
            int x = arr1[i--] + carry - '0';
            if (x >= 10) {
                x -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append((char) ('0' + x));
        }

        while (j >= 0) {
            int x = arr2[j--] + carry - '0';
            if (x >= 10) {
                x -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append((char) ('0' + x));
        }
        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
