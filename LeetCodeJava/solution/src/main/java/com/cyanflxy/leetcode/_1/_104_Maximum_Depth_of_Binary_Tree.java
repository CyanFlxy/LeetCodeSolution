package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * <p>
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * return its depth = 3.
 * <p>
 * Created by cyanflxy on 2018/6/30.
 */

public class _104_Maximum_Depth_of_Binary_Tree {

    public static void main(String... args) {
        test();
    }

    private static void test() {
        _104_Maximum_Depth_of_Binary_Tree object = new _104_Maximum_Depth_of_Binary_Tree();
        System.out.println(object.maxDepth(TreeNode.create(3, 9, 20, null, null, 15, 7)));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
