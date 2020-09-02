package com.cyanflxy.leetcode._11;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _1160 {
    public int countCharacters(String[] words, String chars) {
        char[] dic = chars.toCharArray();
        Arrays.sort(dic);

        int result = 0;
        for (String s : words) {
            if (isContain(dic, s)) {
                result += s.length();
            }
        }

        return result;
    }

    private boolean isContain(char[] src, String destStr) {
        char[] dst = destStr.toCharArray();
        Arrays.sort(dst);

        int si = 0;
        int di = 0;

        while (di < dst.length && si < src.length) {
            char sc = src[si];
            char dc = dst[di];

            if (sc == dc) {
                si++;
                di++;
            } else if (sc < dc) {
                si++;
            } else {
                return false;
            }

        }

        return di == dst.length;
    }
}
