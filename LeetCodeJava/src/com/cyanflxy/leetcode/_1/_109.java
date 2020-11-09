package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.ListNode;
import com.cyanflxy.leetcode.help.TreeNode;

/**
 * @author cyanflxy
 * @since 2020/8/22
 */
public class _109 {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode mid = findMid(start, end);
        TreeNode node = new TreeNode(mid.val);
        node.left = buildTree(start, mid);
        node.right = buildTree(mid.next, end);

        return node;
    }

    private ListNode findMid(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
