package com.cyanflxy.leetcode._8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2021.05.21
 */
public class _819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }

        StringBuilder sb = new StringBuilder();
        String maxStr = "";
        int maxCount = 0;
        Map<String, Integer> countMap = new HashMap<>();

        for (char ch : paragraph.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.setLength((char) (ch - 'A' + 'a'));
            } else {
                if (sb.length() > 0) {
                    String str = sb.toString();
                    if (!bannedSet.contains(str)) {
                        int count = countMap.getOrDefault(str, 0);
                        count++;
                        countMap.put(str, count);
                        if (count > maxCount) {
                            maxCount = count;
                            maxStr = str;
                        }
                    }
                }
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            String str = sb.toString();
            if (!bannedSet.contains(str)) {
                int count = countMap.getOrDefault(str, 0) + 1;
                if (count > maxCount) {
                    maxStr = str;
                }
            }
        }

        return maxStr;
    }
}
