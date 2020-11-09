package com.cyanflxy.leetcode._4;

/**
 * @author cyanflxy
 * @since 2020/8/26
 */
public class _430 {

    public static void main(String... args) {
        _430 o = new _430();
        Node node1 = o.new Node(1);
        Node node2 = o.new Node(2);
        Node node3 = o.new Node(3);
        Node node4 = o.new Node(4);
        Node node5 = o.new Node(5);
        Node node6 = o.new Node(6);
        Node node7 = o.new Node(7);
        Node node8 = o.new Node(8);
        Node node9 = o.new Node(9);
        Node node10 = o.new Node(10);
        Node node11 = o.new Node(11);
        Node node12 = o.new Node(12);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.prev = node5;
        node5.prev = node4;
        node4.prev = node3;
        node3.prev = node2;
        node2.prev = node1;

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.prev = node9;
        node9.prev = node8;
        node8.prev = node7;

        node11.next = node12;
        node12.prev = node11;

        node3.child = node7;
        node8.child = node11;

        o.flatten(node1);
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        return flatten(head, null);
    }

    private Node flatten(Node head, Node end) {
        Node node = head;
        Node pre = node;

        while (node != null) {
            pre = node;
            if (node.child != null) {
                Node next = node.next;

                node.next = flatten(node.child, next);
                node.next.prev = node;

                node.child = null;
                node = next;
            } else {
                node = node.next;
            }
        }

        if (end != null) {
            pre.next = end;
            end.prev = pre;
        }

        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + val + '}';
        }
    }
}
