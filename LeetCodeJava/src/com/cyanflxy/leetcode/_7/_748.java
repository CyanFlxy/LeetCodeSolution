package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.08
 */
public class _748 {
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long licenseValue = getStringValue(licensePlate);

        String result = null;
        for (String str : words) {
            long strValue = getStringValue(str);
            if (strValue % licenseValue == 0) {
                if (result == null || result.length() > str.length()) {
                    result = str;
                }
            }
        }

        return result;

    }

    private long getStringValue(String str) {
        long value = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                value *= prime[ch - 'a'];
            } else if (ch >= 'A' && ch <= 'Z') {
                value *= prime[ch - 'A'];
            }
        }
        return value;
    }
}
