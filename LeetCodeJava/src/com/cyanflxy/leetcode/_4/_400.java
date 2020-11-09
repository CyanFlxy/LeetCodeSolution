package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2020/11/7
 */
public class _400 {

    public static void main(String... args) {
        int n = new _400().findNthDigit(1000000000);
        System.out.println(n);
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long tenth = 1;
        int base = 0;
        int count = 0;

        while (n > count + tenth * digit * 9) {
            count += tenth * digit * 9;
            base += tenth * 9;
            digit++;
            tenth *= 10;
        }

        n -= count;
        int num = (n + digit - 1) / digit + base;
        int index;
        if (n % digit == 0) {
            index = 0;
        } else {
            index = digit - n % digit;
        }

        while (index > 0) {
            num /= 10;
            index--;
        }

        return num % 10;
    }
}
