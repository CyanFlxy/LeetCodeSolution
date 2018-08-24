package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <pre>
 *       1
 *      / \
 *     2   5
 *    / \   \
 *   3   4   6
 * </pre>
 * The flattened tree should look like:
 * <pre>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * </pre>
 * Created by cyanflxy on 2018/8/24.
 */

public class _114_Flatten_Binary_Tree_to_Linked_List {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _114_Flatten_Binary_Tree_to_Linked_List object = new _114_Flatten_Binary_Tree_to_Linked_List();
        TreeNode root = TreeNode.create(1, 2, 5, 3, 4, null, 6);
        object.flatten(root);
        System.out.println(root.toString());
    }

    public void flatten(TreeNode root) {
        flattenNode(root);
    }

    private TreeNode flattenNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return root;
        }

        if (left == null) {
            return flattenNode(right);
        }

        if (right == null) {
            root.left = null;
            root.right = left;
            return flattenNode(left);
        }

        TreeNode leftEnd = flattenNode(left);
        root.left = null;
        root.right = left;
        leftEnd.right = right;

        return flattenNode(right);
    }
}
