package com.cyanflxy.leetcode.offer;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;

        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }

        return n1;
    }
}
