package com.cyanflxy.leetcode._7;

import com.cyanflxy.leetcode.help.ListNode;

/**
 * @author cyanflxy
 * @since 2020/8/25
 */
public class _725 {

    public static void main(String... args) {
        ListNode root = ListNode.create(1, 2);
        ListNode[] result = new _725().splitListToParts(root, 3);

        for (ListNode node : result) {
            System.out.println(node);
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        result[0] = root;

        if (root == null || root.next == null) {
            return result;
        }

        int count = 0;
        ListNode node = root;
        while (node != null) {
            node = node.next;
            count++;
        }

        int size = count / k;
        int over = count % k;


        node = root;
        for (int i = 1; i < k; i++) {
            int number = size - 1 + (i <= over ? 1 : 0);
            while (number-- > 0 && node != null) {
                node = node.next;
            }

            if (node != null) {
                result[i] = node.next;
                node.next = null;
                node = result[i];
            }

        }

        return result;
    }

    // 方案不可行！
    public ListNode[] splitListToParts2(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }

        ListNode[] nodes = new ListNode[k];

        for (int i = 0; i < k; i++) {
            nodes[i] = root;
        }

        while (nodes[k - 1] != null && nodes[k - 1].next != null) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j <= i; j++) {
                    nodes[i] = nodes[i] == null ? null : nodes[i].next;
                }
            }
        }

        for (int i = k - 1; i > 0; i--) {
            nodes[i] = nodes[i - 1].next;
            nodes[i - 1].next = null;
        }

        nodes[0] = root;
        return nodes;
    }
}
