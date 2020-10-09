package com.cyanflxy.leetcode._13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/10/9
 */
public class _1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] cache = new int[arr.length];
        System.arraycopy(arr, 0, cache, 0, arr.length);

        Arrays.sort(cache);

        Map<Integer, Integer> map = new HashMap<>(arr.length * 2);
        int index = 1;
        for (int n : cache) {
            if (!map.containsKey(n)) {
                map.put(n, index++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
