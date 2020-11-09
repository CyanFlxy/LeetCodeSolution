package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            count[c - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
