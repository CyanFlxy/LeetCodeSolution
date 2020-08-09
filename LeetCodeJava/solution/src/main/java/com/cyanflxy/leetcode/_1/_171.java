package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2020/8/9
 */
public class _171 {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();

        int result = 0;
        for (char c : chars) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

}
