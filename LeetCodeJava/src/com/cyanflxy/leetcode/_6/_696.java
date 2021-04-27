package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _696 {
    public int countBinarySubstrings(String s) {
        char lastChar = ' ';
        int curCount = 0;
        int lastCount = 0;
        int result = 0;

        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch == lastChar) {
                curCount++;
            } else {
                result += Math.min(lastCount, curCount);
                lastCount = curCount;
                lastChar = ch;
                curCount = 1;
            }
        }
        result += Math.min(lastCount, curCount);
        return result;
    }
}
