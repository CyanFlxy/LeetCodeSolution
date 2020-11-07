package com.cyanflxy.leetcode._0;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 * <p>
 * Created by cyanflxy on 2018/3/8.
 */

public class _53_Maximum_Subarray {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _53_Maximum_Subarray object = new _53_Maximum_Subarray();
        object.test(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});//6
        object.test(new int[]{-1, -2, -3, -4, -5});//-1
        object.test(new int[]{-5, 1, 2, -4});//3
        object.test(new int[]{3});//3
        object.test(new int[]{-3, -4});//-3
        object.test(new int[]{-3, 4});//4
        object.test(new int[]{-6, -7, -1, -2, -3, -4, -5});//-1
    }

    private void test(int[] nums) {
        System.out.println("real result: " + testMaxSubArray(nums) + " here is: " + maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    // 结果正确，但是超时了
    public int testMaxSubArray(int[] nums) {

        int len = nums.length;

        int[] values = new int[len];
        values[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < len; i++) {
            values[i] = values[i - 1] + nums[i];
            result = Math.max(result, values[i]);
        }

        for (int i = 1; i < len; i++) {
            int k = nums[i - 1];
            for (int j = i; j < len; j++) {
                values[j] -= k;
                result = Math.max(result, values[j]);
            }
        }

        return result;
    }
}
