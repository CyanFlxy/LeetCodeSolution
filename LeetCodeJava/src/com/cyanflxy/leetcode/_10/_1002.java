package com.cyanflxy.leetcode._10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.06.24
 */
public class _1002 {
    public List<String> commonChars(String[] A) {
        int[][] count = new int[A.length][26];

        for (int i = 0; i < A.length; i++) {
            char[] arr = A[i].toCharArray();
            int[] arrCount = count[i];
            for (char c : arr) {
                arrCount[c - 'a']++;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = 1000;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(min, count[j][i]);
            }

            if (min > 0) {
                for (int k = 0; k < min; k++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return result;
    }
}
