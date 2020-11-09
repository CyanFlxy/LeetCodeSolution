package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/11/8
 */
public class _374 {

    public static void main(String... args) {
        int result = new _374(1702766719).guessNumber(2126753390);
        System.out.println(result);
    }

    private int target;

    public _374(int target) {
        this.target = target;
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int h = (l + r) >>> 1;
            int result = guess(h);
            if (result == 0) {
                return h;
            } else if (result < 0) {
                r = h - 1;
            } else {
                l = h + 1;
            }
        }

        return 1;
    }

    int guess(int num) {
        if (num == target) {
            return 0;
        } else if (num < target) {
            return 1;
        } else {
            return -1;
        }
    }
}
