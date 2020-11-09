package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i) - 'a';
            if (magazineCount[c] > 0) {
                magazineCount[c]--;
            } else {
                return false;
            }
        }

        return true;
    }
}
