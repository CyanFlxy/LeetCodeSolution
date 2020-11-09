package com.cyanflxy.leetcode.offer;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
