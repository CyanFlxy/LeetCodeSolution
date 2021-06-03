package com.cyanflxy.leetcode._5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.06.03
 */
public class _525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int zero = 0;
        int one = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                zero++;
            } else {
                one++;
            }

            int diff = one - zero;
            if (map.containsKey(diff)) {
                max = Math.max(max, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }

        return max;
    }
}
