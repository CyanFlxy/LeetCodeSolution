package com.cyanflxy.leetcode._9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> resultArray = new ArrayList<>();
        if (x == 1 && y == 1) {
            if (bound >= 2) {
                resultArray.add(2);
            }
            return resultArray;
        }

        if (y == 1) {
            y = x;
            x = 1;
        }

        Set<Integer> result = new HashSet<>();

        int a = 1;
        outer:
        while (true) {
            int b = 1;
            while (true) {
                int k = a + b;
                if (k <= bound) {
                    result.add(k);
                } else {
                    if (b == 1) {
                        break outer;
                    } else {
                        break;
                    }
                }
                b *= y;
            }
            a *= x;

            if (x == 1) {
                break;
            }
        }

        return new ArrayList<>(result);
    }
}
