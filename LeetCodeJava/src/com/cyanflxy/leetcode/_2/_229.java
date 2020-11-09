package com.cyanflxy.leetcode._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/11/2
 */
public class _229 {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        int value = len / 3;
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            if (count > value) {
                result.add(i);
            }
        }

        return result;
    }
}
