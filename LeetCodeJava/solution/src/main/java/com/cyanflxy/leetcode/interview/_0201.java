package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class _0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = head;
        ListNode node = head;
        Set<Integer> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node.val)) {
                pre.next = node.next;
            } else {
                set.add(node.val);
                pre = node;
            }
            node = node.next;
        }

        return head;
    }
}
