package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * return its minimum depth = 2.
 * <p>
 * Created by cyanflxy on 2018/7/5.
 */
public class _111_Minimum_Depth_of_Binary_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _111_Minimum_Depth_of_Binary_Tree object = new _111_Minimum_Depth_of_Binary_Tree();
        System.out.println(object.minDepth(TreeNode.create(3, 9, 20, null, null, 15, 7)));// 2
        System.out.println(object.minDepth(TreeNode.create(3, 9))); // 2
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
