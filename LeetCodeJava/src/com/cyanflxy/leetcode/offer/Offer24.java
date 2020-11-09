package com.cyanflxy.leetcode.offer;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/24
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode tmp;

        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        return pre;
    }
}
