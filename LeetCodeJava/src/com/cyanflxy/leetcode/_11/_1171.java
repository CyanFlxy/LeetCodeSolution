package com.cyanflxy.leetcode._11;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        int sum = 0;
        ListNode n = head;
        while (n != null) {
            sum += n.val;
            n = n.next;
            if (sum == 0) {
                return removeZeroSumSublists(n);
            }
        }

        head.next = removeZeroSumSublists(head.next);
        return head;
    }

}
