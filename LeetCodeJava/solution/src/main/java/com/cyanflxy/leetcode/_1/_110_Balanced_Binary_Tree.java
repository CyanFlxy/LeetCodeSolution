package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <pre>
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * </pre>
 * Return false.
 * Created by cyanflxy on 2018/7/5.
 */

public class _110_Balanced_Binary_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _110_Balanced_Binary_Tree object = new _110_Balanced_Binary_Tree();
        System.out.println(object.isBalanced(TreeNode.create(3, 9, 20, null, null, 15, 7)));
        System.out.println(object.isBalanced(TreeNode.create(1, 2, 2, 3, 3, null, null, 4, 4)));
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ld = depth(node.left);
        int rd = depth(node.right);

        if (ld < 0 || rd < 0 || Math.abs(ld - rd) > 1) {
            return -1;
        }

        return Math.max(ld, rd) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = getNodeDepth(root.left);
        int rightDepth = getNodeDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int getNodeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getNodeDepth(node.left), getNodeDepth(node.right)) + 1;
    }

}
