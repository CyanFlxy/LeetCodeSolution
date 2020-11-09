package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Created by cyanflxy on 2018/2/25.
 */

public class _23_Merge_k_Sorted_Lists {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _23_Merge_k_Sorted_Lists object = new _23_Merge_k_Sorted_Lists();

        System.out.println(object.mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        }));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int len = lists.length;

        while (len > 1) {
            int index = len & 2;
            for (int i = index; i < len; i += 2, index++) {
                lists[index] = mergeTwoLists(lists[i], lists[i + 1]);
            }
            len = index;
        }

        return lists[0];
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }

        current.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
