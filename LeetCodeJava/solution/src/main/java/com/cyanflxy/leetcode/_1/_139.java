package com.cyanflxy.leetcode._1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/11/1
 */
public class _139 {

    public boolean wordBreak(String s, List<String> wordDict) {
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

}
