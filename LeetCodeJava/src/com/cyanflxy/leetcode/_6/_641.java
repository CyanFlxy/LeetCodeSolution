package com.cyanflxy.leetcode._6;

public class _641 {
    class MyCircularDeque {

        private int[] content;
        private int len;
        private int front;
        private int last;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            len = k + 1;
            content = new int[len];
        }

        private int toIndex(int i) {
            return (i + len) % len;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return front == last;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return toIndex(last + 1) == front;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            front = toIndex(front - 1);
            content[front] = value;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            content[last] = value;
            last = toIndex(last + 1);
            return true;

        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = toIndex(front + 1);
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            last = toIndex(last - 1);
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return content[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return content[toIndex(last - 1)];
        }

    }

}
