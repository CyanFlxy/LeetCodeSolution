package com.cyanflxy.leetcode._2;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _234 {

    public static void main(String... args) {
        ListNode node = ListNode.create(1, 2, 3, 4, 1);
        boolean result = new _234().isPalindrome(node);
        System.out.println(result);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = null;
        ListNode tmp;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            tmp = slow;
            slow = slow.next;

            tmp.next = pre;
            pre = tmp;

        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && pre != null) {
            if (slow.val != pre.val) {
                return false;
            }

            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }


}
