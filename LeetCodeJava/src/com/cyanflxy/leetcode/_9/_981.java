package com.cyanflxy.leetcode._9;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2021.07.12
 */
public class _981 {
    class TimeMap {

        private final Map<String, ArrayList<Pair<Integer, String>>> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            ArrayList<Pair<Integer, String>> list = map.computeIfAbsent(key, s -> new ArrayList<>());
            list.add(new Pair<>(timestamp, value));
        }

        public String get(String key, int timestamp) {
            ArrayList<Pair<Integer, String>> list = map.get(key);
            if (list == null || list.isEmpty() || list.get(0).getKey() > timestamp) {
                return "";
            }

            int l = 0;
            int h = list.size() - 1;
            while (l < h) {
                int m = (l + h + 1) / 2;
                if (list.get(m).getKey() > timestamp) {
                    h = m - 1;
                } else {
                    l = m;
                }
            }
            return list.get(l).getValue();
        }
    }

}
