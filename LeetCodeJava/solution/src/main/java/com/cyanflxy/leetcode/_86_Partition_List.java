package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/partition-list/description/
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * <p>
 * Created by cyanflxy on 2018/4/14.
 */

public class _86_Partition_List {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _86_Partition_List object = new _86_Partition_List();

        System.out.println(object.partition(ListNode.create(1, 4, 3, 2, 5, 2), 3));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode pre1 = l1;
        ListNode pre2 = l2;

        while (head != null) {
            if (head.val < x) {
                pre1.next = head;
                pre1 = pre1.next;
            } else {
                pre2.next = head;
                pre2 = pre2.next;
            }
            head = head.next;
        }

        pre1.next = l2.next;
        pre2.next = null;
        return l1.next;
    }
}
