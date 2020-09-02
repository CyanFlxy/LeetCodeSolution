package com.cyanflxy.leetcode._11;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _1160 {

    public int countCharacters(String[] words, String chars) {
        int[] dic = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            dic[chars.charAt(i) - 'a']++;
        }

        int result = 0;
        for (String s : words) {
            if (contain(s, dic)) {
                result += s.length();
            }
        }

        return result;
    }

    private boolean contain(String str, int[] dic) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            count[index]++;
            if (count[index] > dic[index]) {
                return false;
            }
        }
        return true;
    }


    public int countCharacters1(String[] words, String chars) {
        char[] dic = chars.toCharArray();
        Arrays.sort(dic);

        int result = 0;
        for (String s : words) {
            if (isContain1(dic, s)) {
                result += s.length();
            }
        }

        return result;
    }

    private boolean isContain1(char[] src, String destStr) {
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
