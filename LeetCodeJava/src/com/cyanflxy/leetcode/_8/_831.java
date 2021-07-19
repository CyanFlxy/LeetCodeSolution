package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.07.19
 */
public class _831 {
    public static void main(String[] args) {
        System.out.println(new _831().maskPII("LeetCode@LeetCode.com"));
        System.out.println(new _831().maskPII("AB@qq.com"));
        System.out.println(new _831().maskPII("1(234)567-890"));
        System.out.println(new _831().maskPII("86-(10)12345678"));
    }


    public String maskPII(String s) {
        int atIndex = s.indexOf('@');
        if (atIndex > 0) {
            String name = s.substring(0, atIndex);
            return Character.toLowerCase(name.charAt(0))
                    + "*****"
                    + Character.toLowerCase(name.charAt(atIndex - 1))
                    + s.substring(atIndex).toLowerCase();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (sb.length() < 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
        }

        if (sb.length() > 10) {
            int len = sb.length();
            for (int i = 6; i < sb.length() - 4; i++) {
                sb.setCharAt(i, '*');
            }
            sb.insert(len - 4, '-');
            sb.insert(len - 7, '-');
            sb.insert(len - 10, '-');
            sb.insert(0, '+');
        } else {
            sb.insert(6, '-');
            sb.insert(3, '-');
        }

        return sb.toString();
    }

}
