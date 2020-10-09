package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2020/10/9
 */
public class _922 {

    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];

        int oddIdx = 0;
        int evenIdx = 0;
        for (int i = 0; i < A.length; i += 2) {
            while (A[oddIdx] % 2 == 0) {
                oddIdx++;
            }
            while (A[evenIdx] % 2 != 0) {
                evenIdx++;
            }

            result[i] = A[evenIdx];
            result[i + 1] = A[oddIdx];

            evenIdx++;
            oddIdx++;
        }

        return result;
    }

}
