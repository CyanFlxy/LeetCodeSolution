package com.cyanflxy.leetcode._11;

/**
 * @author cyanflxy
 * @since 2021.07.13
 */
public class _1189 {
    public int maxNumberOfBalloons(String text) {
        int[] charCount = new int[26];
        for (char ch : text.toCharArray()) {
            charCount[ch - 'a']++;
        }


        int max = Math.min(charCount['b' - 'a'], charCount[0]);
        max = Math.min(max, charCount['n' - 'a']);
        max = Math.min(max, charCount['l' - 'a'] / 2);
        max = Math.min(max, charCount['o' - 'a'] / 2);
        return max;
    }
}
