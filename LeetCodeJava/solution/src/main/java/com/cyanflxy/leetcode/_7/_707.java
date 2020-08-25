package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class _707 {

    public static void main(String... args) {
        _707 o = new _707();
        MyLinkedList list = o.new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }

    class MyLinkedList {

        private Node head;
        private Node tail;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                return null;
            }
            Node node;
            if (index < size / 2) {
                node = head.next;
                while (index-- > 0) {
                    node = node.next;
                }
            } else {
                node = tail;
                index = size - index;
                while (index-- > 0) {
                    node = node.prev;
                }
            }

            return node;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node node = new Node(val);
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node node = new Node(val);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node current = getNode(index);
                if (current == null) {
                    return;
                }

                Node node = new Node(val);
                node.prev = current.prev;
                node.next = current;

                current.prev.next = node;
                current.prev = node;

                size++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            Node node = getNode(index);
            if (node != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }
        }

    }

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
