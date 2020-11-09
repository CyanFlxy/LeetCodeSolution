package com.cyanflxy.leetcode._13;

/**
 * @author cyanflxy
 * @since 2020/9/23
 */
public class _1323 {
    public int maximum69Number(int num) {
        int val = 0;

        int index = 1;

        while (num > index) {
            int i = num / index % 10;
            if (i == 6) {
                val = index;
            }
            index *= 10;
        }

        return num + val * 3;
    }
}
