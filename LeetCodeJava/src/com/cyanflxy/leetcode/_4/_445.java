package com.cyanflxy.leetcode._4;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _445 {

    public static void main(String... args) {
        ListNode l1 = ListNode.create(9, 1, 6);
        ListNode l2 = ListNode.create(0);
        ListNode result = new _445().addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode n1 = l1;
        ListNode n2 = l2;

        while (n1 != null && n2 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        ListNode list1;
        ListNode list2;

        if (n1 == null && n2 == null) {
            list1 = l1;
            list2 = l2;
        } else {
            list1 = n1 != null ? l1 : l2;
            list2 = new ListNode(0);
            ListNode pre = list2;

            n2 = n1 != null ? n1 : n2;
            while (n2.next != null) {
                pre.next = new ListNode(0);
                pre = pre.next;
                n2 = n2.next;
            }
            pre.next = n1 == null ? l1 : l2;

        }

        ListNode result = addNumberList(list1, list2);
        if (result.val >= 10) {
            result.val -= 10;
            ListNode tmp = new ListNode(1);
            tmp.next = result;
            return tmp;
        } else {
            return result;
        }
    }

    private ListNode addNumberList(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(l1.val + l2.val);

        if (l1.next != null && l2.next != null) {
            ListNode next = addNumberList(l1.next, l2.next);
            node.next = next;
            if (next.val >= 10) {
                next.val -= 10;
                node.val++;
            }
        }

        return node;
    }
}
