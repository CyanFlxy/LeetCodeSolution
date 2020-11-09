package com.cyanflxy.leetcode._3;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _343 {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else {
            int product = 1;
            // 可以不使用循环
            while (n > 4) {
                product *= 3;
                n -= 3;
            }
            product *= n;
            return product;
        }
    }
}
