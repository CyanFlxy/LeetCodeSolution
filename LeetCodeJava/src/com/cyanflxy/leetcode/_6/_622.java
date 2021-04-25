package com.cyanflxy.leetcode._6;

public class _622 {
    class MyCircularQueue {

        private int[] queue;
        private final int count;
        private int front;
        private int rear;
        private int size;

        public MyCircularQueue(int k) {
            count = k;
            queue = new int[k];
            front = rear = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == count;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            size++;
            queue[rear] = value;
            rear = (rear + 1) % count;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            size--;
            front = (front + 1) % count;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }

            return queue[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int r = (rear - 1 + count) % count;
            return queue[r];
        }

    }

}
