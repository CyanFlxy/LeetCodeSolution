package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <ul>
 * <li>You may only use constant extra space.</li>
 * <li>Recursive approach is fine, implicit stack space does not count as extra space for this problem.</li>
 * <li>You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).</li>
 * </ul>
 * <p>
 * Example:
 * <p>
 * Given the following perfect binary tree,
 * <p>
 * <pre>
 *       1
 *     /  \
 *    2    3
 *   / \  / \
 *  4  5  6  7
 * </pre>
 * After calling your function, the tree should look like:
 * <p>
 * <pre>
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \  / \
 *  4->5->6->7 -> NULL
 * </pre>
 *
 * @author cyanflxy
 * @since 2018/11/3
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _116_Populating_Next_Right_Pointers_in_Each_Node object = new _116_Populating_Next_Right_Pointers_in_Each_Node();
        TreeLinkNode root = TreeLinkNode.create(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        object.connect(root);
        System.out.println(root);
    }

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }

        root.left.next = root.right;
        connect(root.left, root.right);
    }

    public void connect(TreeLinkNode left, TreeLinkNode right) {
        if (left.left == null) {
            return;
        }

        connect(left);
        connect(right);

        while (left.right != null) {
            left.right.next = right.left;
            left = left.right;
            right = right.left;
        }

    }
}
