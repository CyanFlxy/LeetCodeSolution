package com.cyanflxy.leetcode._15;

/**
 * @author cyanflxy
 * @since 2020/9/3
 */
public class _1539 {

    public static void main(String... args) {
        int[] arr = {2, 3, 4, 7, 11};
        int result = new _1539().findKthPositive(arr, 8);
        System.out.println(result);
    }

    public int findKthPositive(int[] arr, int k) {
        int last = 0;

        for (int n : arr) {
            int gap = n - last - 1;
            if (k <= gap) {
                return last + k;
            } else {
                k -= gap;
            }
            last = n;
        }
        return arr[arr.length - 1] + k;
    }
}
