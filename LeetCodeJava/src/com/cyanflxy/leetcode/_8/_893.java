package com.cyanflxy.leetcode._8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.05.17
 */
public class _893 {
    public int numSpecialEquivGroups(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : words) {
            String s = getSortedString(str);
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        return countMap.size();
    }

    private String getSortedString(String str) {
        int len = str.length();
        if (len <= 2) {
            return str;
        }

        char[] arr0 = new char[(len + 1) / 2];
        char[] arr1 = new char[len / 2];
        int i0 = 0;
        int i1 = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                arr0[i0++] = str.charAt(i);
            } else {
                arr1[i1++] = str.charAt(i);
            }
        }

        Arrays.sort(arr0);
        Arrays.sort(arr1);

        return new String(arr0) + new String(arr1);
    }
}
