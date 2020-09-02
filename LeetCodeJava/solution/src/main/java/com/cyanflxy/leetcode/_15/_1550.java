package com.cyanflxy.leetcode._15;

/**
 * @author cyanflxy
 * @since 2020/9/2
 */
public class _1550 {

    public boolean threeConsecutiveOdds(int[] arr) {

        int count = 0;
        for (int n : arr) {
            if ((n & 1) == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

}
