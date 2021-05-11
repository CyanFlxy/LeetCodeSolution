package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.11
 */
public class _754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = (int) (Math.sqrt(target * 2 + 0.25) - 0.5 + 1); //加1向上取整
        int sum = (n + 1) * n / 2;
        if ((sum - target) % 2 == 1) {
            return n + 1 + n % 2;
        } else {
            return n;
        }
    }
}
