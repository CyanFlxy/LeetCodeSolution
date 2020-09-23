package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int v = n % 26;
            if (v == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                char i = (char) ('A' + v - 1);
                sb.append(i);
                n /= 26;
            }
        }

        return sb.reverse().toString();
    }
}
