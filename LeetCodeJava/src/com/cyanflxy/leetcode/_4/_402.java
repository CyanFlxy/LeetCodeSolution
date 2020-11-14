package com.cyanflxy.leetcode._4;

public class _402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder(num);

        int upTo = 0;
        while (k > 0 && sb.length() > 0) {
            while (upTo < sb.length() - 1 && sb.charAt(upTo + 1) >= sb.charAt(upTo)) {
                upTo++;
            }

            sb.deleteCharAt(upTo);
            if (upTo > 0) {
                upTo--;
            }
            k--;
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
