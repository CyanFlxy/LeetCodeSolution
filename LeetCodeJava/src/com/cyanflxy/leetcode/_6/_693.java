package com.cyanflxy.leetcode._6;

public class _693 {
    public boolean hasAlternatingBits(int n) {
        int i = n & 1;

        while (n != 0) {
            if (i != (n & 1)) {
                return false;
            }
            i = 1 - i;
            n >>= 1;
        }

        return true;
    }
}
