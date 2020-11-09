package com.cyanflxy.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 * @author cyanflxy
 * @since 2020/8/23
 */
public class Offer35 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node node = head;

        while (node != null) {
            Node t = new Node(node.val);
            t.next = node.next;
            node.next = t;
            node = t.next;
        }

        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }


        node = head;
        Node newHead = head.next;

        while (true) {
            Node t = node.next;
            node.next = t.next;
            node = node.next;
            if (node != null) {
                t.next = node.next;
            } else {
                break;
            }
        }

        return newHead;
    }

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }
}
