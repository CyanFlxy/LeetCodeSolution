package com.cyanflxy.leetcode._3;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/11/5
 */
public class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0;
        int index2 = 0;
        int index = -1;

        while (index1 < nums1.length && index2 < nums2.length) {
            int i1 = nums1[index1];
            int i2 = nums2[index2];

            if (i1 == i2) {
                if (index < 0 || i1 != result[index]) {
                    index++;
                    result[index] = i1;
                }
                index1++;
                index2++;
            } else if (i1 < i2) {
                index1++;
            } else {
                index2++;
            }
        }
        if (index >= 0) {
            int[] realReault = new int[index + 1];
            System.arraycopy(result, 0, realReault, 0, index + 1);
            return realReault;
        } else {
            return new int[0];
        }
    }
}
