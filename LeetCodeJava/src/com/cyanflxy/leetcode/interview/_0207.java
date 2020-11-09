package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 *
 * @author cyanflxy
 * @since 2020/8/22
 */
public class _0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode na = headA;
        int countA = 0;
        while (na.next != null) {
            na = na.next;
            countA++;
        }

        ListNode nb = headB;
        int countB = 0;
        while (nb.next != null) {
            nb = nb.next;
            countB++;
        }

        if (na != nb) {
            return null;
        }

        na = headA;
        nb = headB;
        while (countA > countB) {
            na = na.next;
            countA--;
        }
        while (countA < countB) {
            nb = nb.next;
            countB--;
        }

        while (na != nb) {
            na = na.next;
            nb = nb.next;
        }

        return na;
    }

}
