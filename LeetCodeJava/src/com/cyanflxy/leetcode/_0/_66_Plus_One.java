package com.cyanflxy.leetcode._0;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/description/
 * <p>
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Created by cyanflxy on 2018/3/15.
 */

public class _66_Plus_One {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _66_Plus_One object = new _66_Plus_One();
        System.out.println(Arrays.toString(object.plusOne(new int[]{1, 3, 1,})));
        System.out.println(Arrays.toString(object.plusOne(new int[]{9, 9, 9,})));
        System.out.println(Arrays.toString(object.plusOne(new int[]{1, 0,})));
    }

    // 实际上，算法只需要关注9，就够了。
    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        digits[end] += 1;
        if (digits[end] < 10) {
            return digits;
        }

        int carry = 1;
        digits[end] -= 10;

        for (int i = end - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] >= 10) {
                carry = 1;
                digits[i] -= 10;
            } else {
                carry = 0;
                break;
            }
        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            Arrays.fill(result, 0);
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
