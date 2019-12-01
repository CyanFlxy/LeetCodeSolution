package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/2
 */
public class _1271 {

    public String toHexspeak(String num) {
        long value = Long.valueOf(num);

        StringBuilder sb = new StringBuilder();

        while (value > 0) {
            char c = getChar((int) (value & 0xFL));
            if (c == 0) {
                return "ERROR";
            }
            sb.insert(0, c);
            value >>= 4;
        }

        return sb.toString();
    }

    private char getChar(int v) {
        if (v >= 10) {
            return (char) ('A' + v - 10);
        } else if (v == 0) {
            return 'O';
        } else if (v == 1) {
            return 'I';
        }
        return 0;
    }
}
