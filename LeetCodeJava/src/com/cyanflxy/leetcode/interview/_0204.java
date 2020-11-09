package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list-lcci/
 *
 * @author cyanflxy
 * @since 2020/8/19
 */
public class _0204 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);

        ListNode small = smallHead;
        ListNode big = bigHead;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = head;
            } else {
                big.next = head;
                big = head;
            }
            head = head.next;
        }

        small.next = bigHead.next;
        big.next = null;

        return smallHead.next;
    }
}
