package com.cyanflxy.leetcode._7;

import java.util.LinkedList;

public class _739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }

        int[] result = new int[T.length];
        LinkedList<Integer> index = new LinkedList<>();
        index.addFirst(0);

        for (int i = 1; i < T.length; i++) {
            while (index.size() > 0 && T[i] > T[index.peekFirst()]) {
                int lastSmall = index.removeFirst();
                result[lastSmall] = i - lastSmall;
            }
            index.addFirst(i);
        }

        return result;
    }
}
