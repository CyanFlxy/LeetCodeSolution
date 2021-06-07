package com.cyanflxy.leetcode._4;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.06.07
 */
public class _494 {

    public static void main(String[] args) {
        int result;
//        result = new _494().findTargetSumWays(Utils.toArray(1, 1, 1, 1, 1), 3);
//        System.out.println(result);
        int[] nums = Utils.toArray(2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53);
        result = new _494().findTargetSumWays(nums, 1000);
        System.out.println(result);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (target > sum || target < -sum) {
            return 0;
        }

        int[] result = new int[sum * 2 + 2];
        result[sum] = 1;

        for (int n : nums) {
            int[] back = new int[result.length];
            for (int i = 0; i < result.length; i++) {
                int r = result[i];
                if (r != 0) {
                    back[i - n] += r;
                    back[i + n] += r;
                }
            }
            result = back;
        }
        return result[target + sum];
    }
}
