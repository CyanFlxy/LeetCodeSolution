package com.cyanflxy.leetcode._1;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/9/12
 */
public class _189 {
    public static void main(String... args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        new _189().rotate(arr, 2);
        System.out.println(Arrays.toString(arr));

    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int r = len - k % len;
        if (r == 0) {
            return;
        }

        int times = greatestCommonDivisor(len, r);

        for (int t = 0; t < times; t++) {
            int index = t;
            int start = nums[index];
            for (int i = 1; i < len / times; i++) {
                int next = (index + r) % len;
                nums[index] = nums[next];
                index = next;
            }
            nums[index] = start;
        }
    }

    private int greatestCommonDivisor(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        int c = a % b;
        return greatestCommonDivisor(b, c);
    }
}
