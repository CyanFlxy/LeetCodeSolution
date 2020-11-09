package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/9/8
 */
public class _633 {
    public boolean judgeSquareSum(int c) {
        int start = (int) Math.sqrt(c / 2);
        int end = (int) Math.sqrt(c);
        int back = start;

        while (start <= end) {
            int result = start * start + back * back;
            if (result == c) {
                return true;
            } else if (result > c) {
                back--;
            } else {
                start++;
            }
        }

        return false;
    }
}
