package com.cyanflxy.leetcode._2;

/**
 * @author cyanflxy
 * @since 2020/8/12
 */
public class _213 {

    public static void main(String... args) {
        int result = new _213().rob(new int[]{4, 1, 2, 7, 5, 3, 1});
        System.out.println(result);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 3) {
            int max = 0;
            for (int i : nums) {
                max = Math.max(max, i);
            }
            return max;
        }

        int len = nums.length;
        int firstMax = 0;
        int pre1 = Math.max(nums[0], nums[1]);
        int pre2 = nums[0];
        for (int i = 2; i < len - 1; i++) {
            firstMax = Math.max(pre1, nums[i] + pre2);
            pre2 = pre1;
            pre1 = firstMax;
        }

        if (nums[len - 1] + pre1 < firstMax) {
            return firstMax;
        }

        int secondMax = 0;
        pre1 = Math.max(nums[1], nums[2]);
        pre2 = nums[1];
        for (int i = 3; i < len; i++) {
            secondMax = Math.max(pre1, nums[i] + pre2);
            pre2 = pre1;
            pre1 = secondMax;
        }

        return Math.max(firstMax, secondMax);
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 3) {
            int max = 0;
            for (int i : nums) {
                max = Math.max(max, i);
            }
            return max;
        }

        int len = nums.length;
        int[] firstRoll = new int[len - 1];
        firstRoll[0] = nums[0];
        firstRoll[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len - 1; i++) {
            firstRoll[i] = Math.max(firstRoll[i - 1], nums[i] + firstRoll[i - 2]);
        }

        if (nums[len - 1] + firstRoll[len - 3] < firstRoll[len - 2]) {
            return firstRoll[len - 2];
        }

        nums[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < len; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }

        return Math.max(firstRoll[len - 2], nums[len - 1]);
    }

}
