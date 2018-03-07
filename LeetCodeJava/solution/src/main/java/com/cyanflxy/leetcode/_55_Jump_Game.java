package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/jump-game/description/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:<br>
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 * <p>
 * Created by cyanflxy on 2018/3/7.
 */

public class _55_Jump_Game {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _55_Jump_Game object = new _55_Jump_Game();

//        System.out.println(object.canJump(new int[]{2, 3, 1, 1, 4}));//true
//        System.out.println(object.canJump(new int[]{3, 2, 1, 0, 4}));//false
//        System.out.println(object.canJump(new int[]{1, 2}));//true
//        System.out.println(object.canJump(new int[]{4, 3, 2, 1, 0, 0}));//false
        System.out.println(object.canJump(new int[]{1, 2, 3}));//true
        System.out.println(object.canJump(new int[]{0}));//false
    }


    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int p = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= p) {
                p = i;
            }
        }

        return p == 0;
    }

//    public boolean canJump(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return false;
//        }
//
//        int len = nums.length;
//        boolean[] possible = new boolean[len];
//        Arrays.fill(possible, false);
//        possible[0] = true;
//        int maxPossible = 0;
//
//        for (int i = 0; i < len - 1; i++) {
//            if (possible[i]) {
//
//                if (i + nums[i] > maxPossible) {
//                    if (i + nums[i] >= len - 1) {
//                        return true;
//                    }
//                    for (int j = maxPossible + 1; j <= i + nums[i] && j < len; j++) {
//                        possible[j] = true;
//                    }
//                    maxPossible = i + nums[i];
//                }
//
//            }
//        }
//
//        return possible[len - 1];
//    }
}
