package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivid(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDivid(int n) {
        if (n < 10) {
            return true;
        }

        int p = 1;
        while (n > p) {
            int i = n / p % 10;
            if (i == 0 || n % i != 0) {
                return false;
            }
            p *= 10;
        }

        return true;
    }
}
