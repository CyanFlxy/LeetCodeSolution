package com.cyanflxy.leetcode._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _146 {

    public static class LRUCache {

        private int capacity;
        private int size;
        private Map<Integer, Value> values2;
        private Value headValue;
        private Value tailValue;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;

            values2 = new HashMap<>();
            headValue = new Value();
            tailValue = new Value();
            headValue.next = tailValue;
            tailValue.prev = headValue;
        }

        public int get(int key) {
            if (values2.containsKey(key)) {
                Value v = values2.get(key);
                updateValue(v);
                return v.val;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (values2.containsKey(key)) {
                Value v = values2.get(key);
                v.val = value;
                updateValue(v);
            } else {
                Value v = new Value();
                v.key = key;
                v.val = value;
                values2.put(key, v);
                addToTail(v);
                size++;

                if (size > capacity) {
                    size--;
                    removeHead();
                }

            }

        }

        private void updateValue(Value v) {
            v.prev.next = v.next;
            v.next.prev = v.prev;

            addToTail(v);
        }

        private void addToTail(Value v) {
            v.prev = tailValue.prev;
            v.next = tailValue;

            tailValue.prev.next = v;
            tailValue.prev = v;
        }

        private void removeHead() {
            Value v = headValue.next;
            headValue.next = v.next;
            v.next.prev = headValue;
            values2.remove(v.key);
        }

        private static class Value {
            int key;
            int val;
            Value next;
            Value prev;
        }
    }
}
