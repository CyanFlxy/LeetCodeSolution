package com.cyanflxy.leetcode._1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _138 {

    public static void main(String... args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        node1.next = node2;
        node1.random = node2;
        node2.random = node2;

        new _138().copyRandomList(node1);
    }

    public Node copyRandomList(Node head) {
        Node copyHead = new Node();

        Node node = head;
        Node copyPrev = copyHead;

        Map<Node, Node> map = new HashMap<>();

        while (node != null) {

            Node copyNode = new Node(node.val, null, node.random);
            copyPrev.next = copyNode;
            copyPrev = copyNode;
            map.put(node, copyNode);

            node = node.next;
        }

        node = copyHead.next;
        while (node != null) {
            node.random = map.get(node.random);
            node = node.next;
        }

        return copyHead.next;
    }

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
