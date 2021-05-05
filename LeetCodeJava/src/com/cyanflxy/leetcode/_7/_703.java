package com.cyanflxy.leetcode._7;

import java.util.Arrays;

/**
 * @author cyanflxy
 * @since 2021.05.05
 */
public class _703 {
    class KthLargest {

        private int k;
        private int[] arr;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            Arrays.sort(nums);

            if (nums.length > k) {
                arr = new int[k];
                System.arraycopy(nums, nums.length - k, arr, 0, k);
            } else if (nums.length == k) {
                arr = nums;
            } else {
                arr = new int[k];
                System.arraycopy(nums, 0, arr, k - nums.length, nums.length);
                for (int i = 0; i < k - nums.length; i++) {
                    arr[i] = Integer.MIN_VALUE;
                }
            }
        }

        public int add(int val) {
            if (val > arr[0]) {
                int i = 0;
                while (i < k - 1 && val > arr[i + 1]) {
                    arr[i] = arr[i + 1];
                    i++;
                }
                arr[i] = val;
            }

            return arr[0];
        }
    }
}
