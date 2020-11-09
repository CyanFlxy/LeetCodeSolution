package com.cyanflxy.leetcode._9;

/**
 * @author cyanflxy
 * @since 2020/8/26
 */
public class _977 {

    // 计算过程中，不会对数据内数据进行排序，1ms
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int start = 0;
        int end = n - 1;
        int index = end;
        while (index >= 0) {
            int s = A[start] * A[start];
            int e = A[end] * A[end];

            if (s > e) {
                result[index--] = s;
                start++;
            } else {
                result[index--] = e;
                end--;
            }
        }

        return result;
    }

    // 计算过程中包含了一个排序过程，会慢一些，2ms
    public int[] sortedSquares_1(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int start = 0;
        int end = n;

        for (int i : A) {
            int sq = i * i;
            if (i < 0) {
                result[--end] = sq;
            } else {
                while (end < n && sq > result[end]) {
                    result[start++] = result[end++];
                }
                result[start++] = sq;
            }
        }

        return result;
    }
}
