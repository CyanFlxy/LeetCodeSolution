package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 * <p>
 * Created by cyanflxy on 2018/3/7.
 */

public class _45_Jump_Game_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _45_Jump_Game_II object = new _45_Jump_Game_II();

        System.out.println(object.jump(new int[]{2, 3, 1, 1, 4}));//2
        System.out.println(object.jump(new int[]{1, 2}));//1
        System.out.println(object.jump(new int[]{1, 2, 3}));//2
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] count = new int[len];
        count[0] = 0;
        for (int i = 1; i < len; i++) {
            count[i] = Integer.MAX_VALUE;
        }

        int lastMax = 0;
        for (int i = 0; i < len; i++) {
            lastMax--;
            int x = nums[i];
            if (x <= lastMax) {
                continue;
            }
            lastMax = x;
            int step = count[i] + 1;
            for (int j = i + 1; j <= i + x && j < len; j++) {
                count[j] = Math.min(count[j], step);
            }
        }

        return count[len - 1];
    }
}
