package com.cyanflxy.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _2 {

    public String getHint(String secret, String guess) {
        char[] arr1 = secret.toCharArray();
        char[] arr2 = guess.toCharArray();

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        int bulls = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                bulls++;
            } else {
                list1.add(arr1[i]);
                list2.add(arr2[i]);
            }
        }

        int cows = 0;
        for (Character c : list2) {
            if (list1.contains(c)) {
                list1.remove(c);
                cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }

}
