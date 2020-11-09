package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <pre>
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * </pre>
 * <p>
 * Example 2:
 * <pre>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * </pre>
 * Created by cyanflxy on 2018/2/6.
 */

public class _4_Median_of_Two_Sorted_Arrays {

    public static void main(String... args) {
        double result = new _4_Median_of_Two_Sorted_Arrays()
                .findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{3, 4, 5});
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLength = len1 + len2;

        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }

    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
