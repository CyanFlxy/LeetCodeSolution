package com.cyanflxy.leetcode._8;

import java.util.HashSet;
import java.util.Set;

public class _884 {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (String str : A.split(" ")) {
            if (set.contains(str)) {
                result.remove(str);
            } else {
                set.add(str);
                result.add(str);
            }
        }

        for (String str : B.split(" ")) {
            if (set.contains(str)) {
                result.remove(str);
            } else {
                set.add(str);
                result.add(str);
            }
        }

        String[] arr = new String[result.size()];
        result.toArray(arr);
        return arr;
    }
}
