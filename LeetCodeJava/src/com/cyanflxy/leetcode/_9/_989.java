package com.cyanflxy.leetcode._9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.18
 */
public class _989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        int carray = 0;

        while (i >= 0 || k > 0) {
            int a = i >= 0 ? num[i--] : 0;
            int b = k % 10;

            int c = a + b + carray;
            if (c >= 10) {
                result.add(0, c - 10);
                carray = 1;
            } else {
                result.add(0, c);
                carray = 0;
            }

            k /= 10;
        }

        if (carray == 1) {
            result.add(0, 1);
        }

        return result;
    }
}
