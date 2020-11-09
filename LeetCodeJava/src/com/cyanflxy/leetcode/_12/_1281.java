package com.cyanflxy.leetcode._12;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int i = n % 10;
            sum += i;
            product *= i;
            n /= 10;
        }
        return product - sum;
    }
}
