package com.cyanflxy.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.07.19
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int lastRepeat = -1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int last = map.getOrDefault(ch, -1);
            lastRepeat = Math.max(lastRepeat, last);
            result = Math.max(result, i - lastRepeat);
            map.put(ch, i);
        }
        return result;
    }
}
