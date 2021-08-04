package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2021.08.04
 */
public class _1108 {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
