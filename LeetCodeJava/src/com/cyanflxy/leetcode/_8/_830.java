package com.cyanflxy.leetcode._8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.21
 */
public class _830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        if (s.length() <= 2) {
            return result;
        }

        int lastStart = 0;
        int count = 0;
        char lastChar = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == lastChar) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(lastStart);
                    list.add(i - 1);
                    result.add(list);
                }
                lastChar = ch;
                count = 1;
                lastStart = i;
            }
        }

        if (count >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(lastStart);
            list.add(arr.length - 1);
            result.add(list);
        }

        return result;
    }
}
