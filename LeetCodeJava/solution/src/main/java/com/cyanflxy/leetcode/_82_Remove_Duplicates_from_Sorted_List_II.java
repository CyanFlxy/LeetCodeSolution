package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * Created by cyanflxy on 2018/4/3.
 */

public class _82_Remove_Duplicates_from_Sorted_List_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _82_Remove_Duplicates_from_Sorted_List_II object = new _82_Remove_Duplicates_from_Sorted_List_II();
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

        ListNode p = result;
        ListNode q = head;
        ListNode cur = q;

        head = head.next;

        while (head != null) {
            if (head.val == q.val) {
                cur = p;
                cur.next = null;
            } else {
                cur.next = head;
                p = cur;
                q = head;
                cur = q;
            }

            head = head.next;
        }


        return result.next;
    }
}
