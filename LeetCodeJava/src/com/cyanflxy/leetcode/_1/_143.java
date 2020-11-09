package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;

import java.util.ArrayList;

/**
 * @author cyanflxy
 * @since 2020/8/8
 */
public class _143 {

    public static void main(String... args) {
        ListNode head = ListNode.create(1, 2, 3, 4);
        new _143().reorderList(head);
        System.out.println(head);
    }

    /**
     * 解题思路：
     * 1. 通过快慢指针找到链表的中间位置(注意判断奇偶)；
     * 2. 将后半段单链表逆转
     * 3. 合并两个单链表
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> nodeArray = new ArrayList<>();
        while (head != null) {
            nodeArray.add(head);
            head = head.next;
        }

        int start = 0;
        int end = nodeArray.size() - 1;
        boolean flip = true;

        ListNode current = nodeArray.get(start++);
        while (start <= end) {
            if (flip) {
                current.next = nodeArray.get(end--);
            } else {
                current.next = nodeArray.get(start++);
            }
            current = current.next;
            current.next = null;
            flip = !flip;
        }

    }

}
