package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/23
 */
public class _148 {

    public static void main(String... args) {
        ListNode node = new _148().sortList(ListNode.create(4, 2, 1, 3));
        System.out.println(node);
    }

    // 归并排序
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode tmp = slow.next;
//        slow.next = null;
//
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//
//        ListNode newHead = new ListNode(0);
//        ListNode pre = newHead;
//
//        while (left != null && right != null) {
//            if (left.val > right.val) {
//                pre.next = right;
//                right = right.next;
//            } else {
//                pre.next = left;
//                left = left.next;
//            }
//            pre = pre.next;
//        }
//
//        pre.next = left != null ? left : right;
//        return newHead.next;
//    }

    // 快速排序 - 优化方案：一次搜索过程中，将与当前节点相等的节点放到单独的链表中，不再重复排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        ListNode equalPre = head;

        ListNode smallHead = new ListNode(0);
        ListNode smallPre = smallHead;

        ListNode bigHead = new ListNode(0);
        ListNode bigPre = bigHead;

        while (node != null) {
            if (node.val < head.val) {
                smallPre.next = node;
                smallPre = node;
            } else if (node.val > head.val) {
                bigPre.next = node;
                bigPre = node;
            } else {
                equalPre.next = node;
                equalPre = node;
            }

            node = node.next;
        }

        equalPre.next = null;
        smallPre.next = null;
        bigPre.next = null;

        smallHead.next = sortList(smallHead.next);
        bigHead.next = sortList(bigHead.next);

        smallPre = smallHead;
        while (smallPre.next != null) {
            smallPre = smallPre.next;
        }

        smallPre.next = head;
        equalPre.next = bigHead.next;

        return smallHead.next;
    }

}
