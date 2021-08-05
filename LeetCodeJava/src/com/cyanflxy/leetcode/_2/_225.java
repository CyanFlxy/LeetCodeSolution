package com.cyanflxy.leetcode._2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cyanflxy
 * @since 2021.08.05
 */
public class _225 {
    class MyStack {

        private Queue<Integer> deque1 = new LinkedList<>();
        private Queue<Integer> deque2 = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            deque1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (deque1.size() > 1) {
                deque2.offer(deque1.poll());
            }

            Queue<Integer> tmp = deque1;
            deque1 = deque2;
            deque2 = tmp;

            return deque2.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            int x = pop();
            push(x);
            return x;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return deque1.isEmpty();
        }
    }
}
