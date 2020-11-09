package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/19
 */
public class _237 {

    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }

        pre.next = null;
    }

}
