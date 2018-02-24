package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <pre>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * </pre>
 * Created by cyanflxy on 2018/2/24.
 */

public class _21_Merge_Two_Sorted_Lists {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _21_Merge_Two_Sorted_Lists object = new _21_Merge_Two_Sorted_Lists();

        System.out.println(object.mergeTwoLists(
                null,
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        ));
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return head.next;
    }

}
