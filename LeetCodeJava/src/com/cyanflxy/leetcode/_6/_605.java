package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/9/9
 */
public class _605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        if (len == 1) {
            return flowerbed[0] == 0 || n == 0;
        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            flowerbed[len - 1] = 1;
            n--;
        }

        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }

            if (n <= 0) {
                break;
            }
        }

        return n <= 0;
    }
}
