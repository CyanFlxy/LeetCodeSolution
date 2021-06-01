package com.cyanflxy.leetcode._8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.06.01
 */
public class _842 {
    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();

        List<Integer> result;
        for (int i = 1; i <= len / 2 && i < 10; i++) {
            for (int j = i + 1; j <= i + (len - i) / 2 && (j - i) < 10; j++) {
                result = check(S, i, j);
                if (result != null) {
                    return result;
                }
            }
        }

        return new ArrayList<>();
    }

    private List<Integer> check(String s, int i1, int i2) {
        if (i1 > 1 && s.charAt(0) == '0') {
            return null;
        }
        if ((i2 - i1) > 1 && s.charAt(i1) == '0') {
            return null;
        }

        int len = s.length();
        String s1 = s.substring(0, i1);
        String s2 = s.substring(i1, i2);

        int f1 = Integer.valueOf(s1);
        int f2 = Integer.valueOf(s2);
        int next = i2;

        List<Integer> result = new ArrayList<>();
        result.add(f1);
        result.add(f2);

        while (next < len) {
            int fn = f1 + f2;
            String sn = String.valueOf(fn);
            if (next + sn.length() > len) {
                return null;
            }

            for (int i = 0; i < sn.length(); i++) {
                if (s.charAt(next++) != sn.charAt(i)) {
                    return null;
                }
            }
            f1 = f2;
            f2 = fn;
            result.add(fn);
        }

        return result;
    }
}
