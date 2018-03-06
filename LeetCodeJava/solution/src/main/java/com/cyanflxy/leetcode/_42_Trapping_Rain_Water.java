package com.cyanflxy.leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p>
 * Created by cyanflxy on 2018/3/6.
 */

public class _42_Trapping_Rain_Water {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _42_Trapping_Rain_Water object = new _42_Trapping_Rain_Water();

        System.out.println(object.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));//6
        System.out.println(object.trap(new int[]{1, 0, 2, 0, 3}));// 3
        System.out.println(object.trap(new int[]{3, 0, 2, 0, 1}));//3
    }

    // 这里的想法是，先顺序走一遍，然后逆序回到最高的位置。
    // 实际上，可以从两边最矮的下手，想最高的中间靠拢
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int len = height.length;

        // 记录最高点
        int highestIndex = -1;
        int highestResult = 0;

        int result = 0;
        int currentHighest = 0;

        for (int i = 0; i < len; i++) {
            if (height[i] >= currentHighest) {
                currentHighest = height[i];
                highestIndex = i;
                highestResult = result;
            } else {
                result += currentHighest - height[i];
            }
        }

        result = highestResult;
        currentHighest = 0;

        for (int i = len - 1; i >= highestIndex; i--) {
            if (height[i] >= currentHighest) {
                currentHighest = height[i];
            } else {
                result += currentHighest - height[i];
            }
        }

        return result;
    }

}
