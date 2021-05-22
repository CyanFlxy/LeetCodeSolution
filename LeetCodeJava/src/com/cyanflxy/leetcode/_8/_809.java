package com.cyanflxy.leetcode._8;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.05.22
 */
public class _809 {

    public static void main(String[] args) {
        int result = new _809().expressiveWords("heeellooo", Utils.toArray("hello", "hi", "helo"));
        System.out.println(result);
    }

    public int expressiveWords(String s, String[] words) {
        if (s.length() < 3) {
            int result = 0;
            for (String word : words) {
                if (s.equals(word)) {
                    result++;
                }
            }
            return result;
        }

        int[][] exp = getStringExt(s);

        int result = 0;
        for (String word : words) {
            if (word.length() < s.length() && canStretchy(word, exp)) {
                result++;
            }
        }
        return result;
    }

    private int[][] getStringExt(String s) {
        int[][] exp = new int[s.length()][2];
        char[] arr = s.toCharArray();

        int index = 0;
        int lastCh = arr[0];
        int lastCount = 1;

        for (int i = 1; i <= arr.length; i++) {
            char ch = i < arr.length ? arr[i] : 0;
            if (ch == lastCh) {
                lastCount++;
            } else {
                exp[index][0] = lastCh;
                exp[index][1] = lastCount;

                index++;
                lastCh = ch;
                lastCount = 1;
            }
        }
        return exp;
    }

    private boolean canStretchy(String word, int[][] exp) {
        if (word.length() == 0) {
            return false;
        }
        char[] arr = word.toCharArray();

        char lastCh = arr[0];
        int lastCount = 1;
        int index = 0;
        if (lastCh != exp[0][0]) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == lastCh) {
                lastCount++;
            } else {
                int targetCount = exp[index][1];
                if (lastCount > targetCount) {
                    return false;
                } else if (lastCount < targetCount) {
                    if (targetCount < 3) {
                        return false;
                    }
                }

                index++;
                if (ch != exp[index][0]) {
                    return false;
                }

                lastCh = ch;
                lastCount = 1;
            }
        }

        int targetCount = exp[index][1];
        if (lastCount > targetCount) {
            return false;
        } else if (lastCount < targetCount) {
            if (targetCount < 3) {
                return false;
            }
        }

        return exp[index + 1][0] == 0;
    }
}
