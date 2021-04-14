package com.cyanflxy.leetcode._5;

import java.util.Arrays;
import java.util.Comparator;

public class _506 {
    public String[] findRelativeRanks(int[] score) {
        Integer[] index = new Integer[score.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, Comparator.comparingInt(o -> -score[o]));

        String[] result = new String[index.length];
        if (index.length >= 1) {
            result[index[0]] = "Gold Medal";
        }
        if (index.length >= 2) {
            result[index[1]] = "Silver Medal";
        }
        if (index.length >= 3) {
            result[index[2]] = "Bronze Medal";
        }

        for (int i = 3; i < index.length; i++) {
            result[index[i]] = String.valueOf(i + 1);
        }

        return result;
    }
}
