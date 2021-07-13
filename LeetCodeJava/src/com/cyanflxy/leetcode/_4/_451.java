package com.cyanflxy.leetcode._4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.07.13
 */
public class _451 {
    public String frequencySort(String s) {
        char[] arr = s.toCharArray();

        Character[] charArr = new Character[arr.length];
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            count.put(c, count.getOrDefault(c, 0) + 1);
            charArr[i] = c;
        }

        Arrays.sort(charArr, (o1, o2) -> {
            int c1 = count.get(o1);
            int c2 = count.get(o2);
            if (c1 == c2) {
                return o1 - o2;
            } else {
                return c2 - c1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : charArr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
