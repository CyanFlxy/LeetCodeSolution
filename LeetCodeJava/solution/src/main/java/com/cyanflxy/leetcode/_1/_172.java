package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2020/8/9
 */
public class _172 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 1) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
