package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.06.09
 */
public class _942 {
    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] result = new int[len + 1];
        int l = 0;
        int h = len;
        int index = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                result[index++] = l++;
            } else {
                result[index++] = h--;
            }
        }
        result[index] = h;
        return result;
    }
}
