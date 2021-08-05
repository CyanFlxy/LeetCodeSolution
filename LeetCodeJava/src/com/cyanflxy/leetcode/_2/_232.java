package com.cyanflxy.leetcode._2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cyanflxy
 * @since 2021.08.05
 */
public class _232 {
    class MyQueue {


        private Deque<Integer> deque1 = new LinkedList<>();
        private Deque<Integer> deque2 = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!deque1.isEmpty()) {
                deque2.addFirst(deque1.removeFirst());
            }

            deque1.addFirst(x);

            while (!deque2.isEmpty()) {
                deque1.addFirst(deque2.removeFirst());
            }

        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return deque1.removeFirst();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return deque1.peekFirst();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return deque1.isEmpty();
        }
    }

}
