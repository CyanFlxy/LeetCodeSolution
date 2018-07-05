package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/description/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * <pre>
 *          5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \      \
 *    7    2      1
 * </pre>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * <p>
 * Created by cyanflxy on 2018/7/5.
 */

public class _112_Path_Sum {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _112_Path_Sum object = new _112_Path_Sum();
//        System.out.println(object.hasPathSum(TreeNode.create(3, 9, 20, null, null, 15, 7), 10));
//        System.out.println(object.hasPathSum(TreeNode.create(1, 2), 1));
        System.out.println(object.hasPathSum(TreeNode.create(1, -2, -3, 1, 3, -2, null, -1), -1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int target = sum - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, target) || hasPathSum(root.right, target);
        }
    }

}
