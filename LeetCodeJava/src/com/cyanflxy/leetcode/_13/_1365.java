package com.cyanflxy.leetcode._13;

import java.util.*;

public class _1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (indexMap.containsKey(n)) {
                indexMap.get(n).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                indexMap.put(n, list);
                list.add(i);
            }
        }

        Arrays.sort(nums);

        int[] result = new int[nums.length];
        int lessCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                lessCount = i;
            }

            List<Integer> index = indexMap.get(nums[i]);
            for (int k : index) {
                result[k] = lessCount;
            }

        }

        return result;
    }
}
