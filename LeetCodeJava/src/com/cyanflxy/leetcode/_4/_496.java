package com.cyanflxy.leetcode._4;

import java.util.HashMap;
import java.util.Map;

public class _496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] stack = new int[nums2.length];
        int stackIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums2) {
            while (stackIndex > 0 && stack[stackIndex - 1] < n) {
                stackIndex--;
                map.put(stack[stackIndex], n);
            }
            stack[stackIndex++] = n;
        }
        while (stackIndex-- > 0) {
            map.put(stack[stackIndex], -1);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
