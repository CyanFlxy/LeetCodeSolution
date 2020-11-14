package com.cyanflxy.leetcode._11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2Map.put(arr2[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }

        list.sort((o1, o2) -> {
            Integer i1 = arr2Map.get(o1);
            Integer i2 = arr2Map.get(o2);
            if (i1 == null && i2 == null) {
                return o1 - o2;
            } else if (i2 == null) {
                return -1;
            } else if (i1 == null) {
                return 1;
            } else {
                return i1 - i2;
            }
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
