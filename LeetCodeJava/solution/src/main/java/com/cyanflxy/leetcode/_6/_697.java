package com.cyanflxy.leetcode._6;

/**
 * @author cyanflxy
 * @since 2020/10/8
 */
public class _697 {

    public int findShortestSubArray3(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[][] data = new int[max - min + 1][2];
        max = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] - min;
            int m = ++data[n][0];

            if (m == 1) {
                data[n][1] = i;
            } else if (m == max) {
                result = Math.min(result, i - data[n][1]);
            } else if (m > max) {
                max = m;
                result = i - data[n][1];
            }

        }

        return result + 1;
    }

    public int findShortestSubArray2(int[] nums) {
        int[][] data = new int[50000][3];
        int max = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (data[n][0] == 0) {
                data[n][0] = 1;
                data[n][1] = i;

                result = 0;

            } else {
                int m = ++data[n][0];
                data[n][2] = i;

                if (m == max) {
                    result = Math.min(result, data[n][2] - data[n][1]);
                } else if (m > max) {
                    max = m;
                    result = data[n][2] - data[n][1];
                }
            }
        }

        return result + 1;
    }

    public int findShortestSubArray1(int[] nums) {
        int[][] data = new int[50000][3];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (data[n][0] == 0) {
                data[n][0] = 1;
                data[n][1] = i;
            } else {
                data[n][0]++;
                data[n][2] = i;
                max = Math.max(data[n][0], max);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int[] d : data) {
            if (max == d[0]) {
                result = Math.min(result, d[2] - d[1]);
            }
        }

        return result + 1;
    }

}
