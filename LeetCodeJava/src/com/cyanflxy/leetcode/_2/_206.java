package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/4/12
 */
public class _206 {

    public ListNode reverseList(ListNode head) {
        ListNode oldHead = head;
        ListNode newHead = head;
        ListNode temp;

        while (head != null) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        if (oldHead != null) {
            oldHead.next = null;
        }

        return newHead;
    }

}
