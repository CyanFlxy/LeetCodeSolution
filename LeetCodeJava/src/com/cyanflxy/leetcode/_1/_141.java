package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author cyanflxy
 * @since 2016/10/12.
 */
public class _141 {

    public static void main(String... args) {

    }

    // 如果想不破坏，可以使用快慢节点 for: node1.next == node2.next.next?
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;

            if (cur.next == head) {
                return true;
            }
            cur.next = head;
            cur = next;
        }
        return false;
    }
}