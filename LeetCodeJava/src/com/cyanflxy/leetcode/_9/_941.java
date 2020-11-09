package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2020/11/3
 */
public class _941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length <= 2) {
            return false;
        }

        int len = A.length;
        if (A[0] >= A[1] || A[len - 2] <= A[len - 1]) {
            return false;
        }


        int index = 1;
        for (; index < A.length; index++) {
            if (A[index] == A[index - 1]) {
                return false;
            } else if (A[index] < A[index - 1]) {
                break;
            }
        }


        for (; index < A.length; index++) {
            if (A[index] >= A[index - 1]) {
                return false;
            }
        }

        return true;
    }
}
