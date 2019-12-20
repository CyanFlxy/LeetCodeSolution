package com.cyanflxy.leetcode._10;

/**
 * @author cyanflxy
 * @since 2019/12/20
 */
public class _1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int a : A) {
            total += a;
        }

        if (total % 3 != 0) {
            return false;
        }

        int value = total / 3;

        int sum = 0;
        int leftIndex = -1;
        for (int i = 0; i < A.length - 2; i++) {
            sum += A[i];
            if (sum == value) {
                leftIndex = i;
                break;
            }
        }

        if (leftIndex == -1) {
            return false;
        }

        sum = 0;
        for (int i = A.length - 1; i > leftIndex + 1; i--) {
            sum += A[i];
            if (sum == value) {
                return true;
            }
        }

        return false;
    }
}
