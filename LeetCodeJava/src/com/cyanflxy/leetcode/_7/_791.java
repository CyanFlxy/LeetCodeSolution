package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.12
 */
public class _791 {
    public String customSortString(String order, String str) {
        int[] charCount = new int[26];
        for (char ch : str.toCharArray()) {
            charCount[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            int count = charCount[ch - 'a'];
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                }
                charCount[ch - 'a'] = 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = charCount[i];
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    sb.append((char) ('a' + i));
                }
            }
        }

        return sb.toString();
    }
}
