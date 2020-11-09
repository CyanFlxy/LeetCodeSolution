package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        int count = 0;
        do {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        } while (slow != fast);

        slow = head;
        fast = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
