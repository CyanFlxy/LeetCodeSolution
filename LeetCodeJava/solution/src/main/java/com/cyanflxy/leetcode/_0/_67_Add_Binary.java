package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/add-binary/description/
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100"
 * <p>
 * Created by cyanflxy on 2018/3/15.
 */

public class _67_Add_Binary {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _67_Add_Binary object = new _67_Add_Binary();
        System.out.println(object.addBinary("1111101", "1"));
    }

    // 数据结构选用字符数组，并直接填充字符会更快
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (ai >= 0 && bi >= 0) {
            int v = a.charAt(ai) + b.charAt(bi) + carry - 96;
            if (v >= 2) {
                v -= 2;
                carry = 1;
            } else {
                carry = 0;
            }

            sb.append(v);

            ai--;
            bi--;
        }

        while (ai >= 0) {
            int v = a.charAt(ai) + carry - 48;
            if (v >= 2) {
                v -= 2;
                carry = 1;
            } else {
                carry = 0;
            }

            sb.append(v);
            ai--;
        }

        while (bi >= 0) {
            int v = b.charAt(bi) + carry - 48;
            if (v >= 2) {
                v -= 2;
                carry = 1;
            } else {
                carry = 0;
            }

            sb.append(v);
            bi--;
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
