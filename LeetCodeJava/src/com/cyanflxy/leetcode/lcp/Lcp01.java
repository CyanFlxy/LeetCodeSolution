package com.cyanflxy.leetcode.lcp;

/**
 * https://leetcode-cn.com/problems/guess-numbers/
 *
 * @author cyanflxy
 * @since 2020/8/23
 */
public class Lcp01 {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        if (guess[0] == answer[0]) {
            count++;
        }
        if (guess[1] == answer[1]) {
            count++;
        }
        if (guess[2] == answer[2]) {
            count++;
        }
        return count;
    }
}
