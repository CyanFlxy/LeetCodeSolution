package com.cyanflxy.leetcode._0;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <pre>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * </pre>
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * Created by cyanflxy on 2018/2/22.
 */

public class _19_Remove_Nth_Node_From_End_of_List {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _19_Remove_Nth_Node_From_End_of_List object = new _19_Remove_Nth_Node_From_End_of_List();

        System.out.println(object.removeNthFromEnd(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 4));
    }

    // 使用两个移动节点，其间距为n，同时移动，带头的移动到尾部的时候，尾随的节点就是要删除的！ 这才是"走一遍"的精髓。
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        int index = count - n;
        if (index == 0) {
            return head.next;
        }

        node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;

    }
}
