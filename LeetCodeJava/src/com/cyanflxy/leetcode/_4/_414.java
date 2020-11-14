package com.cyanflxy.leetcode._4;

public class _414 {

    public static void main(String[] args) {
        new _414().thirdMax(new int[]{5, 2, 4, 1, 3, 6, 0});
    }

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int[] max = new int[3];
        max[0] = nums[0];
        int maxIndex = 1;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            if (n == max[0]) {
                continue;
            }
            if (maxIndex > 1 && n == max[1]) {
                continue;
            }

            if (n > max[maxIndex - 1]) {
                if (maxIndex == 1) {
                    max[1] = max[0];
                    max[0] = n;
                    maxIndex = 2;
                } else if (maxIndex == 2) {
                    max[2] = max[1];
                    if (n > max[0]) {
                        max[1] = max[0];
                        max[0] = n;
                    } else {
                        max[1] = n;
                    }
                    maxIndex = 3;
                } else {
                    if (n < max[1]) {
                        max[2] = n;
                    } else if (n < max[0]) {
                        max[2] = max[1];
                        max[1] = n;
                    } else {
                        max[2] = max[1];
                        max[1] = max[0];
                        max[0] = n;
                    }
                }

            } else if (maxIndex < 3) {
                max[maxIndex++] = n;
            }
        }

        if (maxIndex == 3) {
            return max[2];
        } else {
            return max[0];
        }

    }
}
