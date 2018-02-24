package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.ListNode;

import java.util.ArrayList;
import java.util.List;

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

        List<ListNode> nodeList = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            nodeList.add(node);
        }

        int index = nodeList.size() - n;
        if (index < 0 || index >= nodeList.size()) {
            return head;
        } else if (index == 0) {
            return head.next;
        } else {
            ListNode prev = nodeList.get(index - 1);
            ListNode deleted = nodeList.get(index);
            prev.next = deleted.next;
            return head;
        }

    }
}
