package com.cyanflxy.leetcode._7;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.05.11
 */
public class _735 {

    public static void main(String[] args) {
        new _735().asteroidCollision(Utils.toArray(5, 10, -5));
    }

    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int index = 0;

        for (int a : asteroids) {
            if (a > 0) {
                stack[index++] = a;
            } else {
                while (index > 0 && stack[index - 1] > 0) {
                    if (stack[index - 1] > -a) {
                        a = 0;
                        break;
                    } else if (stack[index - 1] == -a) {
                        a = 0;
                        index--;
                    } else {
                        index--;
                    }
                }
                if (a != 0) {
                    stack[index++] = a;
                }
            }
        }
        int[] result = new int[index];
        System.arraycopy(stack, 0, result, 0, index);
        return result;
    }
}
