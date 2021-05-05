package com.cyanflxy.leetcode._7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2021.05.05
 */
public class _705 {
    class MyHashSet {

        private List<Integer>[] listArray;
        private static final int LEN = 997;

        public MyHashSet() {
            listArray = new List[LEN];
        }

        public void add(int key) {
            int bucket = key % LEN;
            if (listArray[bucket] == null) {
                listArray[bucket] = new ArrayList<>();
            } else {
                if (listArray[bucket].contains(key)) {
                    return;
                }
            }
            listArray[bucket].add(key);
        }

        public void remove(int key) {
            int bucket = key % LEN;
            if (listArray[bucket] != null) {
                listArray[bucket].remove((Integer) key);
            }
        }

        public boolean contains(int key) {
            int bucket = key % LEN;
            if (listArray[bucket] != null) {
                return listArray[bucket].contains(key);
            }
            return false;
        }
    }
}
