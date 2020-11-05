package com.cyanflxy.leetcode._3;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2020/11/5
 */
public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(len1, len2)];
        int index1 = 0;
        int index2 = 0;
        int index = -1;


        while (index1 < len1 && index2 < len2) {
            int i1 = nums1[index1];
            int i2 = nums2[index2];

            if (i1 == i2) {
                int count1 = 1;
                while (++index1 < len1 && nums1[index1] == i1) {
                    count1++;
                }

                int count2 = 1;
                while (++index2 < len2 && nums2[index2] == i1) {
                    count2++;
                }

                int count = Math.min(count1, count2);
                Arrays.fill(result, index + 1, index + count + 1, i1);
                index += count;

            } else if (i1 < i2) {
                index1++;
            } else {
                index2++;
            }
        }


        if (index >= 0) {
            return Arrays.copyOf(result, index + 1);
        } else {
            return new int[0];
        }
    }
}
