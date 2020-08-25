package com.cyanflxy.leetcode.offer;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }

        if (k != 0) {
            return null;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
