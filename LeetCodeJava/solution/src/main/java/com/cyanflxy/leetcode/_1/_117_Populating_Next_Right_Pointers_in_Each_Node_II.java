package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * <p>
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <ul>
 * <li>You may only use constant extra space.</li>
 * <li>Recursive approach is fine, implicit stack space does not count as extra space for this problem.</li>
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
 *   / \    \
 *  4  5    7
 * </pre>
 * After calling your function, the tree should look like:
 * <p>
 * <pre>
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \    \
 *  4->5 ->  7 -> NULL
 * </pre>
 *
 * @author cyanflxy
 * @since 2018/11/3
 */
public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _117_Populating_Next_Right_Pointers_in_Each_Node_II object = new _117_Populating_Next_Right_Pointers_in_Each_Node_II();
        TreeLinkNode root = TreeLinkNode.create(1, 2, 3, 4, 5, 6, 7, 8, 9, null, 11, 12, null, 14, 15);
        object.connect(root);
        System.out.println(root);

        root = TreeLinkNode.create(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8);
        object.connect(root);
        System.out.println(root);

        root = TreeLinkNode.create(1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5);
        object.connect(root);
        System.out.println(root);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode nextHead = null;
        TreeLinkNode linkEnd = null;

        TreeLinkNode left, right;

        while (root != null) {
            left = root.left != null ? root.left : root.right;
            right = root.right != null ? root.right : root.left;
            root = root.next;

            if (left == null) {
                continue;
            }

            if (left != right) {
                left.next = right;
            }

            if (nextHead == null) {
                nextHead = left;
            }

            if (linkEnd != null) {
                linkEnd.next = left;
            }

            linkEnd = right;

        }

        connect(nextHead);
    }

}
