package com.cyanflxy.leetcode._8;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.05.15
 */
public class _804 {
    private String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseStr = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                sb.append(morse[ch - 'a']);
            }
            morseStr.add(sb.toString());

            sb.setLength(0);
        }
        return morseStr.size();
    }
}
