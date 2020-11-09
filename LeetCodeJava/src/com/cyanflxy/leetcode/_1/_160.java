package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
