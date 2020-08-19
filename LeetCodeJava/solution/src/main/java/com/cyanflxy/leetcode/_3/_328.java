package com.cyanflxy.leetcode._3;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/19
 */
public class _328 {

    public static void main(String... args) {
        ListNode node = ListNode.create(1, 2, 3, 4, 5, 6, 7);
        ListNode node1 = new _328().oddEvenList(node);
        System.out.println(node1);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;

        ListNode odd = head;
        ListNode even = evenHead;

        do {
            odd.next = even == null ? null : even.next;
            if (odd.next != null) {
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            } else {
                break;
            }
        } while (true);

        odd.next = evenHead;

        return head;
    }

}
