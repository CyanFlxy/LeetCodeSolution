package com.cyanflxy.leetcode._2;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author cyanflxy
 * @since 2020/10/28
 */
public class _205 {
    public boolean isIsomorphic(String s, String t) {
        char[] map1 = new char[128];
        char[] map2 = new char[128];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char sc = sa[i];
            char tc = ta[i];
            char ms = map1[sc];
            char mt = map2[tc];

            if (ms != 0 && mt != 0) {
                if (ms != tc || mt != sc) {
                    return false;
                }
            } else if (ms == 0 && mt == 0) {
                map1[sc] = tc;
                map2[tc] = sc;
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        return isIsomorphicHalf(s, t) && isIsomorphicHalf(t, s);
    }

    public boolean isIsomorphicHalf(String s, String t) {
        char[] map1 = new char[128];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (map1[sc] != 0) {
                if (map1[sc] != tc) {
                    return false;
                }
            } else {
                map1[sc] = tc;
            }

        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        char[] map1 = new char[128];
        char[] map2 = new char[128];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (map1[sc] != 0 && map2[tc] != 0) {
                if (map1[sc] != tc || map2[tc] != sc) {
                    return false;
                }
            } else if (map1[sc] == 0 && map2[tc] == 0) {
                map1[sc] = tc;
                map2[tc] = sc;
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map1 = new TreeMap<>();
        Map<Character, Character> map2 = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (map1.containsKey(sc) && map2.containsKey(tc)) {
                if (map1.get(sc) != tc || map2.get(tc) != sc) {
                    return false;
                }
            } else if (!map1.containsKey(sc) && !map2.containsKey(tc)) {
                map1.put(sc, tc);
                map2.put(tc, sc);
            } else {
                return false;
            }

        }
        return true;
    }
}
