package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _0208 {
    public ListNode detectCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;

        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                break;
            }
        }

        if (l2 == null || l2.next == null) {
            return null;
        }

        l2 = head;

        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }
}
