package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <pre>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * </pre>
 * Created by cyanflxy on 2018/5/21.
 */

public class _92_Reverse_Linked_List_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _92_Reverse_Linked_List_II object = new _92_Reverse_Linked_List_II();

        System.out.println(object.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 2, 4));
        System.out.println(object.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 1, 4));
        System.out.println(object.reverseBetween(ListNode.create(1, 2, 3, 4, 5), 1, 5));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode reverseStart = result;
        ListNode cur = head;

        // pre n node
        while (m > 1) {
            reverseStart = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // reverse n~m
        ListNode pre = cur;
        cur = cur.next;
        ListNode tmp;

        while (n > 1) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            n--;
        }

        // link last node
        ListNode end = reverseStart.next;
        reverseStart.next = pre;
        end.next = cur;

        return result.next;
    }
}
