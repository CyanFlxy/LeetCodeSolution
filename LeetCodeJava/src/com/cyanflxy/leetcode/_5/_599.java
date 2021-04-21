package com.cyanflxy.leetcode._5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            String[] t = list1;
            list1 = list2;
            list2 = t;
        }

        Map<String, Integer> map1 = new HashMap<>(list1.length, 1);
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (i > min) {
                break;
            }

            String str = list2[i];
            if (map1.containsKey(str)) {
                int v = map1.get(str) + i;
                if (v < min) {
                    result.clear();
                    min = v;
                    result.add(str);
                } else if (v == min) {
                    result.add(str);
                }
            }
        }

        return result.toArray(new String[0]);

    }
}
