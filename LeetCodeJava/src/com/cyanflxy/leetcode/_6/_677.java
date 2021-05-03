package com.cyanflxy.leetcode._6;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author cyanflxy
 * @since 2021.05.03
 */
public class _677 {
    class MapSum {

        private TreeMap<String, Integer> treeMap = new TreeMap<>();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            treeMap.put(key, val);
        }

        public int sum(final String prefix) {
            int result = treeMap.getOrDefault(prefix, 0);
            Map.Entry<String, Integer> entry;
            String nextKey = prefix;
            while ((entry = treeMap.higherEntry(nextKey)) != null) {
                if (entry.getKey().startsWith(prefix)) {
                    result += entry.getValue();
                    nextKey = entry.getKey();
                } else {
                    break;
                }
            }
            return result;
        }
    }
}
