package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class _147 {

    public static void main(String... args) {
        new _147().insertionSortList(ListNode.create(4, 2, 1, 3));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(0);

        while (head != null) {
            ListNode t = head;
            head = head.next;

            ListNode sortList = result;
            while (sortList.next != null && sortList.next.val < t.val) {
                sortList = sortList.next;
            }
            t.next = sortList.next;
            sortList.next = t;
        }

        return result.next;
    }
}
