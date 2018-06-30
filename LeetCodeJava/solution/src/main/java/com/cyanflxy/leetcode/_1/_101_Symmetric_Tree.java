package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <pre>
 *       1
 *      / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 * </pre>
 * But the following [1,2,2,null,3,null,3] is not:
 * <pre>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </pre>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p>
 * Created by cyanflxy on 2018/6/30.
 */

public class _101_Symmetric_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _101_Symmetric_Tree object = new _101_Symmetric_Tree();
        System.out.println(object.isSymmetric(TreeNode.create(1, 2, 2, 3, 4, 4, 3)));
        System.out.println(object.isSymmetric(TreeNode.create(1, 2, 2, null, 3, null, 3)));
    }

    // 递归法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricRecursive(left.left, right.right)
                && isSymmetricRecursive(left.right, right.left);
    }
}
