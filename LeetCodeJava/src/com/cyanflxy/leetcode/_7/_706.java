package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.06
 */
public class _706 {
    class MyHashMap {
        private int[] map = new int[1000001];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {

        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            map[key] = value + 1;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            if (map[key] > 0) {
                return map[key] - 1;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            map[key] = 0;
        }
    }
}
