package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _717 {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 1) {
            return true;
        }

        if (bits[len - 2] == 0) {
            return true;
        }

        int i = 0;
        while (i < len - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }

        return i == len - 1;
    }
}
