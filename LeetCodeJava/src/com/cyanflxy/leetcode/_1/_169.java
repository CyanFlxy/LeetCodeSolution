package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2021.06.01
 */
public class _169 {
    public int majorityElement(int[] nums) {
        int n = 0;
        int c = 0;
        for (int x : nums) {
            if (n == x) {
                c++;
            } else {
                c--;
                if (c < 0) {
                    n = x;
                    c = 1;
                }
            }
        }
        return n;
    }
}
