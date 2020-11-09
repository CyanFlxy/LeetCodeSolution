package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/11/1
 */
public class _140 {

    public static void main(String... args) {
        new _140().wordBreak("catsanddog", Utils.toList("cat", "cats", "and", "sand", "dog"));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (!checkWordBreak(s, wordDict)) {
            return result;
        }

        List<String>[] orderDict = new ArrayList[26];
        for (String w : wordDict) {
            int first = w.charAt(0) - 'a';
            if (orderDict[first] == null) {
                orderDict[first] = new ArrayList<>();
            }
            orderDict[first].add(w);
        }

        check(s, 0, orderDict, result, "");
        return result;

    }

    public boolean checkWordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }

    private void check(String src, final int index, List<String>[] orderDict, List<String> result, String current) {
        int first = src.charAt(index) - 'a';
        List<String> dict = orderDict[first];
        if (dict == null) {
            return;
        }

        for (String word : dict) {
            if (index + word.length() > src.length()) {
                continue;
            }

            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                if (src.charAt(index + i) != word.charAt(i)) {
                    match = false;
                }
            }

            if (match) {
                String rst = "".equals(current) ? word : current + " " + word;
                if (index + word.length() == src.length()) {
                    result.add(rst);
                } else {
                    check(src, index + word.length(), orderDict, result, rst);
                }
            }
        }
    }
}
