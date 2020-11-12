package com.cyanflxy.leetcode._4;

public class _405 {

    public static void main(String[] args) {
        new _405().toHex(-1);
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            int n = num & 0xF;
            if (n < 10) {
                sb.append((char) ('0' + n));
            } else {
                sb.append((char) ('a' + n - 10));
            }
            num >>>= 4;
        }

        return sb.reverse().toString();
    }

    public String toHex1(int num) {
        StringBuffer sb = new StringBuffer();

        int filter = 0xF0000000;
        for (int i = 7; i >= 0; i--) {
            int n = (num & filter) >>> (i * 4);
            filter >>= 4;

            if (n == 0) {
                if (sb.length() != 0) {
                    sb.append('0');
                }
            } else if (n < 10) {
                sb.append((char) ('0' + n));
            } else {
                sb.append((char) ('a' + n - 10));
            }
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

}
