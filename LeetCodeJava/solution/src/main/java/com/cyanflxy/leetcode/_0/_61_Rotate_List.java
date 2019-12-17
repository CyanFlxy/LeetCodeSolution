package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/description/
 * <p>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * <p>
 * Example:
 * <pre>
 * Given 1->2->3->4->5->NULL and k = 2,
 *
 * return 4->5->1->2->3->NULL.
 * </pre>
 * Created by cyanflxy on 2018/3/14.
 */

public class _61_Rotate_List {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _61_Rotate_List object = new _61_Rotate_List();
//        System.out.println(object.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 11));
//
//        System.out.println(object.rotateRight(new ListNode(1), 2));
        System.out.println(object.rotateRight(null, 1));
        System.out.println(object.rotateRight(new ListNode(1, new ListNode(2)), 3));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        ListNode tail = null;
        int count = 0;
        while (node != null) {
            count++;
            if (node.next == null) {
                tail = node;
            }
            node = node.next;
        }

        int index = count - (k % count);
        node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }

        tail.next = head;
        head = node.next;
        node.next = null;

        return head;
    }

}
