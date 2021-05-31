package com.cyanflxy.leetcode._1;

/**
 * @author cyanflxy
 * @since 2021.05.31
 */
public class _155 {
    class MinStack {

        Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            head = new Node();
            head.min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            Node node = new Node();
            node.val = val;
            node.min = Math.min(val, head.min);
            node.next = head;
            head = node;
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        class Node {
            int val;
            int min;
            Node next;
        }
    }

}
