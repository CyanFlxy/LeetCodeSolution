package com.cyanflxy.leetcode._7;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.09
 */
public class _744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = Arrays.binarySearch(letters, target);
        if (index < 0) {
            index = -index - 1;
        } else {
            index++;
        }

        while (true) {
            if (index == letters.length) {
                index = 0;
            }
            if (letters[index] != target) {
                break;
            }
            index++;
        }

        return letters[index];
    }
}
