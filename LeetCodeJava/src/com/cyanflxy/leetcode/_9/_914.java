package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2021.06.04
 */
public class _914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int max = 0;
        for (int d : deck) {
            max = Math.max(max, d);
        }

        int[] count = new int[max + 1];
        for (int d : deck) {
            count[d]++;
        }

        int x = count[deck[0]];
        for (int c : count) {
            if (c > 0) {
                x = gcd(c, x);
                if (x <= 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }

        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return gcd(b, r);
        }
    }
}
