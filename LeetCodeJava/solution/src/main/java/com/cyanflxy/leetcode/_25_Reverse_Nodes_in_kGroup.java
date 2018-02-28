package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Created by cyanflxy on 2018/2/28.
 */

public class _25_Reverse_Nodes_in_kGroup {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _25_Reverse_Nodes_in_kGroup object = new _25_Reverse_Nodes_in_kGroup();

        System.out.println(object.reverseKGroup(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))),
                4));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;

        ListNode temp;
        int count = 1;

        for (; count < k && current != null; count++) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        if (count != k) {
            current = pre.next;
            pre.next = null;
            while (current != null) {
                temp = current.next;
                current.next = pre;
                pre = current;
                current = temp;
            }
            return head;
        } else {
            head.next = reverseKGroup(current, k);
            return pre;
        }

    }
}
