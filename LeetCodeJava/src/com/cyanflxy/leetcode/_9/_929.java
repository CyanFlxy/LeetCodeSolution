package com.cyanflxy.leetcode._9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.05.25
 */
public class _929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(checkEmail(email));
        }
        return set.size();
    }

    private String checkEmail(String email) {
        StringBuilder sb = new StringBuilder();
        int atIndex = email.indexOf('@');
        for (int i = 0; i < atIndex; i++) {
            char ch = email.charAt(i);
            if (ch == '+') {
                break;
            } else if (ch != '.') {
                sb.append(ch);
            }
        }

        sb.append(email.substring(atIndex));
        return sb.toString();
    }
}
