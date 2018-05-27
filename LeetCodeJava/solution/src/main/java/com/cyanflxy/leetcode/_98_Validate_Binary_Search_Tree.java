package com.cyanflxy.leetcode;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <pre>
 * Input:
 *   2
 *  / \
 * 1   3
 * Output: true
 * </pre>
 * Example 2:
 * <pre>
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 * </pre>
 * Created by cyanflxy on 2018/5/27.
 */

public class _98_Validate_Binary_Search_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _98_Validate_Binary_Search_Tree object = new _98_Validate_Binary_Search_Tree();
        System.out.println(object.isValidBST(new TreeNode(Integer.MAX_VALUE)));
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || max <= node.val) {
            return false;
        }

        return isValid(node.left, min, node.val)
                && isValid(node.right, node.val, max);
    }

}
