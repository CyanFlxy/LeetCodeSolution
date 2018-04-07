package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * Created by cyanflxy on 2018/4/7.
 */

public class _83_Remove_Duplicates_from_Sorted_List {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _83_Remove_Duplicates_from_Sorted_List object = new _83_Remove_Duplicates_from_Sorted_List();
        System.out.println(object.deleteDuplicates(
                new ListNode(3)
        ));

        System.out.println(object.deleteDuplicates(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))
        ));
        System.out.println(object.deleteDuplicates(
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))
        ));
        System.out.println(object.deleteDuplicates(
                new ListNode(1, new ListNode(1))
        ));
        System.out.println(object.deleteDuplicates(
                new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))))
        ));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode cur = head;
        head = head.next;
        cur.next = null;

        while (head != null) {
            if (head.val != cur.val) {
                cur.next = head;
                cur = head;
                head = head.next;
                cur.next = null;
            } else {
                head = head.next;
            }
        }

        return result.next;
    }
}
