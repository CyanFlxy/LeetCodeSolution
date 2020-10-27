package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/10/27
 */
public class _389 {

    public static void main(String... args) {
        new _389().findTheDifference("abcd", "abcde");
    }

    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        char[] saar = s.toCharArray();
        char[] taar = t.toCharArray();

        for (char c : saar) {
            count[c - 'a']++;
        }

        for (char c : taar) {
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] == -1) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}
