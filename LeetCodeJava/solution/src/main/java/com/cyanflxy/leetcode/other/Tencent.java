package com.cyanflxy.leetcode.other;


public class Tencent {
    public static void main(String... args) {
        // 将字符串转换为double
        String val = "-12.4";

        double result = 0;
        boolean dot = false;
        double dotVal = 0.1;
        int p = 1;

        int start = 0;
        if (val.charAt(0) == '+') {
            start = 1;
        } else if (val.charAt(0) == '-') {
            start = 1;
            p = -1;
        }

        for (int i = start; i < val.length(); i++) {
            char c = val.charAt(i);
            if (c == '.') {
                dot = true;
            } else {
                if (dot) {
                    result = result + (c - '0') * dotVal;
                    dotVal /= 10;
                } else {
                    result = result * 10 + (c - '0');
                }
            }
        }

        result *= p;

        System.out.println(result);
    }
}
