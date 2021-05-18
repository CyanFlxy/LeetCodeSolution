package com.cyanflxy.leetcode._8;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _859 {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length() || a.length() <= 1) {
            return false;
        }

        int len = a.length();
        char da = 0;
        char db = 0;
        boolean swapped = false;
        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca != cb) {
                if (da != 0) {
                    if (swapped) {
                        return false;
                    } else if (da == cb && db == ca) {
                        swapped = true;
                    } else {
                        return false;
                    }
                } else {
                    da = ca;
                    db = cb;
                }
            } else {
                count[ca - 'a']++;
            }
        }

        if (swapped) {
            return true;
        } else {
            if (da != 0) {
                return false;
            }
            for (int c : count) {
                if (c > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
