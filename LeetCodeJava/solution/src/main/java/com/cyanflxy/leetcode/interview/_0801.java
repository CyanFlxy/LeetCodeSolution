package com.cyanflxy.leetcode.interview;

/**
 * @author cyanflxy
 * @since 2020/9/1
 */
public class _0801 {

    public static void main(String... args) {
        _0801 o = new _0801();

        System.out.println(o.waysToStep(61));
    }

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        int result = 0;

        for (int i = 4; i <= n; i++) {
            result = (n1 + n2) % 1000000007 + n3;
            result = result % 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = result;
        }

        return result;
    }

    public int waysToStep_1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        long n1 = 1;
        long n2 = 2;
        long n3 = 4;
        long result = 0;

        for (int i = 4; i <= n; i++) {
            result = n1 + n2 + n3;
            result = result % 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = result;
        }

        return (int) result;
    }
}
