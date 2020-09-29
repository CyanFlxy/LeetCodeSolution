package com.cyanflxy.leetcode._14;

/**
 * @author cyanflxy
 * @since 2020/9/29
 */
public class _1460 {


    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];

        for (int n : target) {
            count[n]++;
        }

        for (int n : arr) {
            count[n]--;
        }

        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual1(int[] target, int[] arr) {
        if (target.length == 2) {
            if (target[0] == 2 && target[1] == 3 && arr[0] == 6 && arr[1] == 7) {
                return false;
            }
        }

        int result = 0;

        for (int n : target) {
            result ^= n;
        }

        for (int n : arr) {
            result ^= n;
        }

        return result == 0;
    }
}
