package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/24
 */
public class _0205 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }


        ListNode result = new ListNode(0);
        ListNode pre = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val = carry;

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            pre.next = new ListNode(val);
            pre = pre.next;

        }

        if (carry == 1) {
            pre.next = new ListNode(1);
        }

        return result.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode result = l1;
        ListNode pre = l1;
        int carry = 0;

        while (l1 != null && l2 != null) {
            l1.val += l2.val + carry;
            if (l1.val >= 10) {
                l1.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            l1 = l2;
            pre.next = l2;
        }

        while (carry != 0 && l1 != null) {
            l1.val++;
            if (l1.val >= 10) {
                l1.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            pre = l1;
            l1 = l1.next;
        }

        if (carry != 0) {
            pre.next = new ListNode(1);
        }

        return result;
    }

}
