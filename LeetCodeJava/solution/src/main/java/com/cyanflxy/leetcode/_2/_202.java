package com.cyanflxy.leetcode._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/4/12
 */
public class _202 {

    public static void main(String... args) {
        new _202().isHappy(19);
    }

    public boolean isHappy(int n) {
        int result = n;
        Set<Integer> happySet = new HashSet<>();

        do {
            result = calHanppy(result);
            if (happySet.contains(result)) {
                break;
            } else {
                happySet.add(result);
            }
        } while (result != 1);

        return result == 1;
    }

    private int calHanppy(int n) {
        int result = 0;
        while (n > 0) {
            int last = n % 10;
            result += last * last;
            n = n / 10;
        }
        return result;
    }
}
