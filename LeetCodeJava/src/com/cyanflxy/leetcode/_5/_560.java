package com.cyanflxy.leetcode._5;

import com.cyanflxy.leetcode.help.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.05.29
 */
public class _560 {
    public static void main(String[] args) {
        new _560().subarraySum(Utils.toArray(-1, -1, 1), 1);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int sum = 0;
        sumCount.put(0, 1);
        int result = 0;
        for (int num : nums) {
            sum += num;
            result += sumCount.getOrDefault(sum - k, 0);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
