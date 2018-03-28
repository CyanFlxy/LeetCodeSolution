package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * Created by cyanflxy on 2018/3/27.
 */

public class _76_Minimum_Window_Substring {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _76_Minimum_Window_Substring object = new _76_Minimum_Window_Substring();

        System.out.println(object.minWindow("ABCDOBECODEBANC", "ABC"));
        System.out.println(object.minWindow("abc", "aa"));
    }

    // 原始版本是使用Map计数。如果文本范围是1~127，那么使用一个数组会更快。
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0
                || t == null || t.length() == 0
                || s.length() < t.length()) {
            return "";
        }

        int tl = t.length();
        int[] tm = new int[128];
        for (int i = 0; i < tl; i++) {
            tm[t.charAt(i)]++;
        }

        int sl = s.length();
        int cs = 0;
        while (cs < sl && tm[s.charAt(cs)] == 0) {
            cs++;
        }

        if (cs >= sl) {
            return "";
        }

        int[] sm = new int[128];
        int coverCount = 0;

        int ms = 0;
        int me = 0;
        int ml = sl + 1;

        for (int i = cs; i < sl; i++) {
            char c = s.charAt(i);
            if (tm[c] == 0) {
                continue;
            }

            sm[c]++;
            if (sm[c] <= tm[c]) {
                coverCount++;
            }

            if (coverCount >= tl) {
                while (true) {
                    char fc = s.charAt(cs);
                    if (tm[fc] > 0) {
                        if (sm[fc] > tm[fc]) {
                            sm[fc]--;
                        } else {
                            break;
                        }
                    }
                    cs++;
                }

                if (i - cs + 1 < ml) {
                    ml = i - cs + 1;
                    ms = cs;
                    me = i;

                    if (ml == t.length()) {
                        return s.substring(ms, me + 1);
                    }
                }
            }

        }

        if (ml <= s.length()) {
            return s.substring(ms, me + 1);
        } else {
            return "";
        }
    }
}
