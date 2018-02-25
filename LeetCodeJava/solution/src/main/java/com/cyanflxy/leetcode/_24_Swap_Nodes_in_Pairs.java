package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p>
 * Created by cyanflxy on 2018/2/25.
 */
public class _24_Swap_Nodes_in_Pairs {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _24_Swap_Nodes_in_Pairs object = new _24_Swap_Nodes_in_Pairs();

        System.out.println(object.swapPairs(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))
        ));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headNode = new ListNode(0);
        headNode.next = head;

        ListNode current = headNode;
        ListNode next1;
        ListNode next2;

        ListNode next3;

        while (current.next != null && current.next.next != null) {
            next1 = current.next;
            next2 = next1.next;
            next3 = next2.next;

            current.next = next2;
            next2.next = next1;
            next1.next = next3;
            current = next1;

        }

        return headNode.next;
    }
}
