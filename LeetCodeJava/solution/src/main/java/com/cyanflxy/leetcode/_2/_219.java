package com.cyanflxy.leetcode._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/9/2
 */
public class _219 {

    public static void main(String... args) {
//        new _219().containsNearbyDuplicate(new int[]{1, 1}, 2);
        new _219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }

    // 速度快，耗内存
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;

        Map<Integer, Integer> numIndex = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int n = nums[i];
            if (numIndex.containsKey(n)) {
                int v = i - numIndex.get(n);
                if (v <= k) {
                    return true;
                }
            }
            numIndex.put(n, i);
        }

        return false;
    }


    // 省内存但是速度很慢，时间复杂度是O(n*k)
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j <= i + k && j < len; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
