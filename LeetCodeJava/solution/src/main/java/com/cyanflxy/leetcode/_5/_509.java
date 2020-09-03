package com.cyanflxy.leetcode._5;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _509 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            int result = 1;
            int pre1 = 1;
            int pre2 = 0;
            for (int i = 2; i <= N; i++) {
                result = pre1 + pre2;
                pre2 = pre1;
                pre1 = result;
            }

            return result;
        }
    }
}
