package com.cyanflxy.leetcode._13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/9/12
 */
public class _1338 {


    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : arr) {
            if (count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            } else {
                count.put(n, 1);
            }
        }

        List<Integer> sort = new ArrayList<>(count.values());
        Collections.sort(sort);

        int total = (arr.length + 1) / 2;
        int result = 0;
        for (int i = sort.size() - 1; i >= 0; i--) {
            total -= sort.get(i);
            result++;
            if (total <= 0) {
                return result;
            }
        }

        return 0;
    }

}
