package com.cyanflxy.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space
 * (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in
 * nums1 and nums2 are m and n respectively.
 * <p>
 * Created by cyanflxy on 2018/4/15.
 */

public class _88_Merge_Sorted_Array {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _88_Merge_Sorted_Array object = new _88_Merge_Sorted_Array();

        int[] num1 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        int[] num2 = {3, 5, 7, 9, 10};
        object.merge(num1, 5, num2, 5);
        System.out.println(Arrays.toString(num1));

        num1 = new int[]{0};
        num2 = new int[]{1};
        object.merge(num1, 0, num2, 1);
        System.out.println(Arrays.toString(num1));

    }

    // 逆向思维考虑，倒着复制！
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums1, 0, nums1, n, m);
//
//        int len = m + n;
//        int p1 = n;
//        int p2 = 0;
//        int i = 0;
//        while (p1 < len && p2 < n) {
//            int n1 = nums1[p1];
//            int n2 = nums2[p2];
//            if (n1 < n2) {
//                nums1[i] = n1;
//                p1++;
//            } else {
//                nums1[i] = n2;
//                p2++;
//            }
//            i++;
//        }
//
//        if (p2 < n) {
//            System.arraycopy(nums2, p2, nums1, i, n - p2);
//        }
//    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            } else if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }
}
