package com.cyanflxy.leetcode._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.07.15
 */
public class _290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mapR = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            String word = words[i];

            String mapWord = map.get(ch);
            Character mapCh = mapR.get(word);

            if (mapWord != null || mapCh != null) {
                if (!word.equals(mapWord) || !ch.equals(mapCh)) {
                    return false;
                }
            } else {
                map.put(ch, word);
                mapR.put(word, ch);
            }
        }
        return true;
    }
}
