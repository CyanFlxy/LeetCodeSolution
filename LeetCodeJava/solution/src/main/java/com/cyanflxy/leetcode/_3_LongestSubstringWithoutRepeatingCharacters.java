package com.cyanflxy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * </p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Created by XiaYuqiang on 2016/10/18.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String... args) {
        // c, cc, abcabcd
        String str = "abcabcd";
        int result = lengthOfLongestSubstring(str);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        int lastStartIndex = 0;
        int maxLength = 0;

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                if (maxLength < charMap.size()) {
                    maxLength = charMap.size();
                }

                int lastIndex = charMap.get(c);
                for (int j = lastStartIndex; j <= lastIndex; j++) {
                    charMap.remove(s.charAt(j));
                }
                lastStartIndex = lastIndex + 1;
            }
            charMap.put(s.charAt(i), i);
        }

        if (maxLength < charMap.size()) {
            maxLength = charMap.size();
        }

        return maxLength;
    }

}
