package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2019/12/10
 */
public class _1221 {
    public int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        int balance = 0;
        int count = 0;
        for (char c : arr) {
            if (c == 'R') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }

        return count;
    }
}
