package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2020/9/10
 */
public class _1615 {
    public int[] masterMind(String solution, String guess) {
        int a = 0;
        char[] ss = new char[4];
        char[] gg = new char[4];
        int index = 0;

        for (int i = 0; i < 4; i++) {
            char s = solution.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                a++;
            } else {
                ss[index] = s;
                gg[index++] = g;
            }
        }

        int remain = 4 - a;
        int b = 0;
        for (int i = 0; i < remain; i++) {
            for (int j = 0; j < remain; j++) {
                if (gg[i] == ss[j]) {
                    ss[j] = 0;
                    b++;
                    break;
                }
            }
        }

        return new int[]{a, b};
    }
}
