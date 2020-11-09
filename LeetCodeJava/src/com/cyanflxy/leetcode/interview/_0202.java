package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 *
 * @author cyanflxy
 * @since 2020/8/22
 */
public class _0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode n1 = head;
        while (k > 0) {
            n1 = n1.next;
            k--;
        }

        ListNode n2 = head;
        while (n1 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2.val;
    }
}
